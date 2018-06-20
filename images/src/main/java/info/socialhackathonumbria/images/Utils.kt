package info.socialhackathonumbria.images

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 20/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */
object Utils {

//    fun generateImages (count : Int, width : Int, height : Int) : List<String> {
//        var countImages = 0 until count
//        var countUrls = countImages.map { "https://picsum.photos/$width/$height/?image=$it"}
//        return countUrls
//    }

    fun generateImages(count : Int, width : Int = 1080, height : Int = 1920) : List<String> =
            (0 until count).map { "https://picsum.photos/$width/$height/?image=$it"}

}