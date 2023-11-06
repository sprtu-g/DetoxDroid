package com.flx_apps.digitaldetox.system_integration

import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import com.flx_apps.digitaldetox.DetoxDroidApplication
import java.time.LocalDate
import java.time.ZoneId

/**
 * A singleton that provides access to the [UsageStatsManager] and caches the usage stats for the
 * current day. This is used, for example, to determine the screen time of the current day.
 */
object UsageStatsProvider {
    /**
     * The timestamp of the last refresh of [usageStatsToday]. This is used to cache the usage stats
     * for one minute.
     */
    private var usageStatsTodayLastRefresh = 0L

    /**
     * Returns the usage stats for the current day. This list is cached for one minute to reduce
     * the number of calls to the system service.
     */
    var usageStatsToday: Map<String, UsageStats> = mapOf()
        get() {
            val now = System.currentTimeMillis()
            if (now - usageStatsTodayLastRefresh > 1000 * 10) {
                val usageStatsManager = DetoxDroidApplication.appContext.getSystemService(
                    Context.USAGE_STATS_SERVICE
                ) as UsageStatsManager

                val dayBeginningMs =
                    LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()
                        .toEpochMilli()
                field = usageStatsManager.queryUsageStats(
                    UsageStatsManager.INTERVAL_DAILY, dayBeginningMs, now
                ).filter { it.firstTimeStamp > dayBeginningMs && it.totalTimeInForeground > 0 }
                    .groupingBy { it.packageName }.aggregate { key, accumulator, element, first ->
                        if (first) element else accumulator!!.apply { add(element) }
                    }
                usageStatsTodayLastRefresh = now
            }
            return field
        }

    /**
     * The total screen time of the current day in milliseconds.
     */
    val screenTimeToday = usageStatsToday.values.sumOf { it.totalTimeInForeground }
}