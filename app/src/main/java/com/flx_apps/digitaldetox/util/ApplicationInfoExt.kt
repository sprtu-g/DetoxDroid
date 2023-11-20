package com.flx_apps.digitaldetox.util

import android.content.Context
import android.content.pm.ApplicationInfo
import com.flx_apps.digitaldetox.R

/**
 * Extension function for [ApplicationInfo] to get the app category title. It first tries to get the
 * title from the package name (for known apps, that are hard-coded in this function). If that fails,
 * it obtains title from the category, if available by the system (see [ApplicationInfo.category]).
 * @param context The context to get the string from.
 */
fun ApplicationInfo.getAppCategoryTitle(
    context: Context
): String {
    // region App category package names
    val socialNetworkAppIds = setOf(
        "com.whatsapp",
        "com.facebook.orca",
        "com.facebook.katana",
        "com.instagram.android",
        "com.zhiliaoapp.musically",
        "com.facebook.lite",
        "com.snapchat.android",
        "com.twitter.android",
        "video.like",
        "com.facebook.mlite",
        "org.telegram.messenger",
        "jp.naver.line.android",
        "com.viber.voip",
        "com.pinterest",
        "com.bbm",
        "com.ss.android.ugc.trill",
        "com.vkontakte.android",
        "com.ss.android.ugc.boom",
        "com.tencent.mm",
        "com.bitstrips.imoji",
        "com.kwai.video",
        "com.zhiliaoapp.musically.go",
        "com.discord",
        "com.linkedin.android",
        "com.mobilemotion.dubsmash",
        "ru.ok.android",
        "com.kakao.talk",
        "kik.android",
        "com.tumblr",
        "com.bsb.hike",
        "com.google.android.talk",
        "com.google.android.apps.plus",
        "com.cheerfulinc.flipagram",
        "video.like.lite",
        "com.enflick.android.TextNow",
        "com.facebook.pages.app",
        "tv.periscope.android",
        "com.ss.android.ugc.boomlite",
        "me.zepeto.main",
        "com.reddit.frontpage",
        "com.loudtalks",
        "com.asiainno.uplive",
        "com.nhn.android.band",
        "com.kakao.story",
        "com.ss.android.ugc.trill.go",
        "com.unearby.sayhi",
        "com.icq.mobile.client",
        "com.avcrbt.funimate",
        "com.google.android.apps.fireball",
        "com.classdojo.android"
    )
    val musicStreamingAppIds = setOf(
        "com.spotify.music",
        "com.google.android.apps.youtube.music",
        "com.soundcloud.android",
        "com.studiosol.palcomp3",
        "com.bsbportal.music",
        "com.pandora.android",
        "com.google.android.music",
        "mbinc12.mb32b",
        "com.amazon.mp3",
        "ht.nct",
        "ru.yandex.music",
        "com.anghami",
        "com.mmm.trebelmusic",
        "com.spotify.mobile.android.ui",
        "com.aspiro.tidal",
        "com.spotify.lite",
        "my.googlemusic.play",
        "mbinc12.mb32",
        "com.madebyappolis.spinrilla",
        "com.jetappfactory.jetaudio",
        "com.rhapsody",
        "com.rhapsody.napster",
        "com.n7mobile.nplayer",
        "com.stingray.galaxie.android",
        "mb32j.fm.music.player.free.download",
        "com.pandora.android.atv",
        "com.mixerbox.mixerbox2",
        "uk.co.sevendigital.android",
        "com.lge.media.musicflow",
        "com.wMusicParadiseApp",
        "com.raumfeld.android.controller",
        "com.aresmitremusicplayer",
        "com.jacobsmedia.gospel",
        "com.power",
        "net.joltsoft.karaokeanywhere.robot",
        "com.n7mobile.nplayerunlocker",
        "com.mixerbox.mixerbox2b",
        "com.np.noonpacific",
        "com.gurubani.activity",
        "com.airtel.ng.android.music",
        "com.pandora.android.gtv",
        "com.dlna.asus2",
        "com.podomatic.PodOmatic.Dev",
        "com.emporioarmanisounds",
        "com.dmholdings.denonclub",
        "com.arkudadigital.audiostream.full.arkuda.googleplay",
        "com.conversdigital",
        "com.nuvo.android",
        "com.anghami.other",
        "com.airtel.musicbox"
    )
    val videoStreamingAppIds = setOf(
        "com.netflix.mediaclient",
        "com.google.android.youtube",
        "com.google.android.apps.youtube.mango",
        "com.amazon.avod.thirdpartyclient",
        "com.google.android.apps.youtube.kids",
        "org.videolan.vlc",
        "com.tencent.ibg.joox",
        "tv.twitch.android.app",
        "com.google.android.videos",
        "com.tubitv",
        "com.disney.disneyplus",
        "com.hulu.plus",
        "org.videolan.vlc.betav7neon",
        "tv.pluto.android",
        "com.imdb.mobile",
        "com.crunchyroll.crunchyroid",
        "com.roku.remote",
        "com.viki.android",
        "com.gotv.crackle.handset",
        "com.hbo.hbonow",
        "com.amazon.storm.lightning.client.aosp",
        "com.cbs.app",
        "de.twokit.castbrowser",
        "com.bydeluxe.d3.android.program.starz",
        "com.nickonline.android.nickapp",
        "com.hbo.broadband",
        "com.erosnow",
        "com.directv.dvrscheduler",
        "com.plexapp.android",
        "com.xfinity.cloudtvr",
        "air.com.vudu.air.DownloaderTablet",
        "com.mcprohosting.beam",
        "com.fox.now",
        "com.nbcuni.nbc",
        "com.turner.cnvideoapp",
        "com.disney.datg.videoplatforms.android.watchdc",
        "com.cw.fullepisodes.android",
        "org.pbskids.video",
        "com.redbox.android.activity",
        "com.disney.datg.videoplatforms.android.abc",
        "com.HBO",
        "com.TWCableTV",
        "de.twokit.video.tv.cast.browser.samsung",
        "com.hbo.broadband.br",
        "com.google.android.apps.youtube.unplugged",
        "com.starz.starzplay.android",
        "com.sling",
        "com.Funimation.FunimationNow",
        "de.twokit.video.tv.cast.browser.lg",
        "com.sm.SlingGuide.Dish"
    )
    val shoppingAppIds = setOf(
        "com.contextlogic.wish",
        "com.alibaba.aliexpresshd",
        "com.amazon.mShop.android.shopping",
        "in.amazon.mShop.android.shopping",
        "com.ebay.mobile",
        "com.joom",
        "com.alibaba.intl.android.apps.poseidon",
        "com.abtnprojects.ambatana",
        "com.walmart.android",
        "com.offerup",
        "com.contextlogic.geek",
        "com.wallapop",
        "com.ebay.kleinanzeigen",
        "com.amazon.windowshop",
        "com.wayfair.wayfair",
        "com.etsy.android",
        "com.dhgate.buyermob",
        "com.mercariapp.mercari",
        "com.kouzoh.mercari",
        "com.tophatter",
        "com.amazon.mShop.android",
        "com.thirdrock.fivemiles",
        "com.letgo.ar",
        "com.dealdash",
        "com.contextlogic.wishlocal",
        "uk.amazon.mShop.android",
        "com.zulily.android",
        "com.ecg.close5",
        "com.walmart.mg",
        "com.google.android.apps.shopping.express",
        "jp.amazon.mShop.android",
        "com.codified.hipyard",
        "com.amazon.ember.android",
        "de.amazon.mShop.android",
        "com.qvc",
        "com.jet.jet.app",
        "com.listia.Listia",
        "org.craigslist.CraigslistMobile",
        "com.boxed.prod",
        "ca.walmart.ecommerceapp",
        "com.woot.android.main",
        "com.production.truspertips",
        "com.touchofmodern",
        "craigs.pro.plus",
        "com.dhgate.buyer",
        "fr.amazon.mShop.android",
        "me.swiftgift.swiftgift",
        "com.qvcuk",
        "uk.mercariapp.mercari",
        "com.ebay.glance.s2handset"
    )
    val datingAppIds = setOf(
        "com.tinder",
        "com.badoo.mobile",
        "com.myyearbook.m",
        "com.ftw_and_co.happn",
        "net.lovoo.android",
        "com.skout.android",
        "com.pof.android",
        "com.jaumo",
        "com.p1.mobile.putong",
        "drug.vokrug",
        "com.waplog.social",
        "com.taggedapp",
        "com.grindrapp.android",
        "ru.mamba.client",
        "com.okcupid.okcupid",
        "com.zoosk.zoosk",
        "com.bumble.app",
        "com.topface.topface",
        "com.hotornot.app",
        "com.hitwe.android",
        "com.shaadi.android",
        "com.jaumo.prime",
        "com.dating.android",
        "com.hily.app",
        "com.matchlatam.parperfeitoapp",
        "com.twoo",
        "com.jnj.mocospace.android",
        "com.match.android.matchmobile",
        "com.u2opia.woo",
        "com.bluelionmobile.qeep.client.android",
        "de.appfiction.yocutiegoogle",
        "com.wildec.dating.meet4u",
        "co.hinge.app",
        "ru.loveplanet.app",
        "com.ipart.android",
        "com.wildec.fastmeet",
        "ru.mail.love",
        "com.once.android",
        "com.eharmony",
        "com.paktor",
        "com.hoott",
        "fr.im",
        "com.bloomyapp",
        "com.blendr.mobile",
        "com.coffeemeetsbagel",
        "chat.meet.date.me",
        "com.singlesaroundme.android",
        "com.meetme.android.activities",
        "com.matchlatam.ourtimeapp",
        "com.badoo.twa"
    )
    val travelAppIds = setOf(
        "com.tripadvisor.tripadvisor",
        "net.skyscanner.android.main",
        "com.expedia.bookings",
        "com.agoda.mobile.consumer",
        "com.ryanair.cheapflights",
        "com.airasia.mobile",
        "com.kayak.android",
        "com.hopper.mountainview.play",
        "in.goindigo.android",
        "com.mttnow.droid.easyjet",
        "com.united.mobile.android",
        "com.delta.mobile.android",
        "com.southwestairlines.mobile",
        "com.wego.android",
        "com.aa.android",
        "com.wizzair.WizzAirApp",
        "ctrip.english",
        "com.cf.flightsearch",
        "com.hilton.android.hhonors",
        "com.momondo.flightsearch",
        "com.priceline.android.negotiator",
        "com.marriott.mrt",
        "com.lufthansa.android.lufthansa",
        "mobile.latam.com.latamapp",
        "com.pozitron.pegasus",
        "com.mo2o.vueling",
        "com.ba.mobile",
        "com.emirates.ek.android",
        "com.jetradar",
        "com.lixar.allegiant",
        "com.ihg.apps.android",
        "com.accor.appli.hybrid",
        "com.airfrance.android.dinamoprd",
        "Kal.FlightInfo",
        "com.skypicker.main",
        "com.turkishairlines.mobile",
        "com.travelocity.android",
        "com.afklm.mobile.android.gomobile.klm",
        "com.orbitz",
        "com.jetblue.JetBlueAndroid",
        "com.flyfrontier.android",
        "com.fp.cheapoair",
        "com.m.qr",
        "jp.co.ana.android.tabidachi",
        "com.amadeus.merci.client.ui",
        "com.iberia.android",
        "com.hotwire.hotels",
        "com.alaskaairlines.android",
        "com.skiplagged",
        "au.com.qantas.qantas"
    )
    val workoutAppIds = setOf(
        "homeworkout.homeworkouts.noequipment",
        "sixpack.sixpackabs.absworkout",
        "com.xiaomi.hm.health",
        "com.myfitnesspal.android",
        "loseweight.weightloss.workout.fitness",
        "com.sec.android.app.shealth",
        "com.runtastic.android",
        "com.fitbit.FitbitMobile",
        "com.google.android.apps.fitness",
        "losebellyfat.flatstomach.absworkout.fatburning",
        "com.popularapp.thirtydayfitnesschallenge",
        "com.health.lab.drink.water.tracker",
        "pedometer.steptracker.calorieburner.stepcounter",
        "women.workout.female.fitness",
        "com.strava",
        "com.tayu.tau.pedometer",
        "buttocksworkout.hipsworkouts.forwomen.legworkout",
        "com.calm.android",
        "cc.pacer.androidapp",
        "com.nike.plusgps",
        "com.freeletics.lite",
        "com.yazio.android",
        "com.getsomeheadspace.android",
        "com.eyefilter.nightmode.bluelightfilter",
        "com.northpark.drinkwater",
        "com.fatsecret.android",
        "com.popularapp.sevenmins",
        "com.gen.workoutme",
        "cc.forestapp",
        "com.fitnesskeeper.runkeeper.pro",
        "com.garmin.android.apps.connectmobile",
        "com.endomondo.android",
        "musclebooster.workout.home.gym.abs.loseweight",
        "absworkout.bellyfatworkout.waistworkout.abdominalworkout",
        "com.runtastic.android.results.lite",
        "com.nike.ntc",
        "com.healthifyme.basic",
        "com.sillens.shapeupclub",
        "com.jiubang.darlingclock",
        "si.modula.android.instantheartrate",
        "in.sweatco.app",
        "com.mufumbo.android.recipe.search",
        "com.eightfit.app",
        "man.fit.workout.routine.muscle.training",
        "abs.workout.fitness.tabata.hiit.stomach",
        "com.health.drink.water.reminder.tracker",
        "com.health.drinkwater.reminder",
        "com.buzzfeed.tasty",
        "com.dietcoacher.sos",
        "step.tracker.stepcounter.walking"
    )
    // endregion
    var stringResourceId: Int
    // first obtain the string resource id from the package name for known apps
    stringResourceId = when (this.packageName) {
        in socialNetworkAppIds -> R.string.appCategories_social
        in musicStreamingAppIds -> R.string.appCategories_music
        in videoStreamingAppIds -> R.string.appCategories_video
        in shoppingAppIds -> R.string.appCategories_shopping
        in datingAppIds -> R.string.appCategories_dating
        in travelAppIds -> R.string.appCategories_travel
        in workoutAppIds -> R.string.appCategories_workout
        else -> R.string.appCategories_other
    }
    // otherwise, try to obtain the string resource id from the category
    if (stringResourceId == R.string.appCategories_other) {
        stringResourceId = when (this.category) {
            ApplicationInfo.CATEGORY_AUDIO -> R.string.appCategories_audio
            ApplicationInfo.CATEGORY_GAME -> R.string.appCategories_games
            ApplicationInfo.CATEGORY_IMAGE -> R.string.appCategories_image
            ApplicationInfo.CATEGORY_MAPS -> R.string.appCategories_maps
            ApplicationInfo.CATEGORY_NEWS -> R.string.appCategories_news
            ApplicationInfo.CATEGORY_PRODUCTIVITY -> R.string.appCategories_productivity
            ApplicationInfo.CATEGORY_SOCIAL -> R.string.appCategories_social
            ApplicationInfo.CATEGORY_UNDEFINED -> R.string.appCategories_other
            ApplicationInfo.CATEGORY_VIDEO -> R.string.appCategories_video
            else -> R.string.appCategories_other
        }
    }
    return context.getString(stringResourceId)
}