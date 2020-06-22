package com.amzesmoro.blockbuster.data

import com.amzesmoro.blockbuster.R

object MovieData {
    private val movieId = intArrayOf(
        101,
        102,
        103,
        104,
        105,
        106,
        107,
        108,
        109,
        110
    )

    private val movieReleaseDate = arrayOf(
        "May 30, 2019",
        "Jun 28, 2019",
        "May 22, 2019",
        "Jul 12, 2019",
        "Jan 31, 2019",
        "Aug 26, 2016",
        "Mar 15, 2019",
        "May 15, 2017",
        "Jul 11, 2019",
        "February 14, 2019"
    )

    private val movieTitle = arrayOf(
        "Parasite",
        "Spider-Man: Far from Home",
        "Aladdin",
        "The Lion King",
        "Alita: Battle Angel",
        "Your Name",
        "Five Feet Apart",
        "Marlina the Murderer in Four Acts",
        "Two Blue Stripes",
        "Fall in Love at First Kiss"
    )

    private val movieSummary = arrayOf(
        "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous " +
                "Parks for their livelihood until they get entangled in an unexpected incident.",
        "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly " +
                "be able to rest - Peter will have to agree to help Nick Fury uncover the " +
                "mystery of creatures that cause natural disasters and destruction throughout " +
                "the continent.",
        "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding " +
                "a lamp that releases a wisecracking genie while a power-hungry Grand Vizier " +
                "vies for the same lamp that has the power to make their deepest wishes come true.\n",
        "Simba idolizes his father, King Mufasa, and takes to heart his own royal destiny. " +
                "But not everyone in the kingdom celebrates the new cub's arrival. Scar, " +
                "Mufasa's brother—and former heir to the throne—has plans of his own. The " +
                "battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately " +
                "resulting in Simba's exile. With help from a curious pair of newfound friends, " +
                "Simba will have to figure out how to grow up and take back what is rightfully his.",
        "When Alita awakens with no memory of who she is in a future world she does not " +
                "recognize, she is taken in by Ido, a compassionate doctor who realizes that " +
                "somewhere in this abandoned cyborg shell is the heart and soul of a young " +
                "woman with an extraordinary past.",
        "High schoolers Mitsuha and Taki are complete strangers living separate lives. But " +
                "one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, " +
                "and he in hers. This bizarre occurrence continues to happen randomly, and " +
                "the two must adjust their lives around each other.",
        "Seventeen-year-old Stella spends most of her time in the hospital as a cystic fibrosis " +
                "patient. Her life is full of routines, boundaries and self-control — all of " +
                "which get put to the test when she meets Will, an impossibly charming teen " +
                "who has the same illness. There's an instant flirtation, though restrictions " +
                "dictate that they must maintain a safe distance between them. As their " +
                "connection intensifies, so does the temptation to throw the rules out the " +
                "window and embrace that attraction.",
        "In the deserted hills of an Indonesian island, Marlina, a young widow, is attacked, " +
                "raped and robbed for her cattle. To defend herself, she kills several men of " +
                "the gang. Seeking justice, she goes on a journey for empowerment and " +
                "redemption. But the road is long, especially when the ghost of her headless " +
                "victim begins to haunt her.",
        "Bima and Dara are lovers who are still in high school. At the age of 17, they were " +
                "determined to copulate outside of marriage. Dara was pregnant. Both are then " +
                "confronted with a life that is unimaginable for children of their age, life " +
                "as parents.",
        "After an earthquake destroys Xiang Qin's house, she and her father move in with the " +
                "family of her father's college buddy. To her surprise, her new kind and " +
                "amicable aunt and uncle are the parents of her cold and distant schoolmate, " +
                "Jiang Zhi Shu, a genius with an IQ of 200 whom not too long ago rejected " +
                "her when she confessed her feelings for him. Will the close proximity give " +
                "her a second chance to win Zhi Shu's heart? Or will her love for him end " +
                "under his cold words?"
    )

    private val moviePoster = intArrayOf(
        R.drawable.mv_parasite,
        R.drawable.mv_spiderman_far_from_home,
        R.drawable.mv_aladdin,
        R.drawable.mv_lion_king,
        R.drawable.mv_alita,
        R.drawable.mv_your_name,
        R.drawable.mv_five_feet_apart,
        R.drawable.mv_marlina,
        R.drawable.mv_two_blue_stripes,
        R.drawable.mv_fall_in_love_first_kiss
    )

    private val movieBackdropPoster = intArrayOf(
        R.drawable.mv_backdrop_parasite,
        R.drawable.mv_backdrop_spiderman_far_from_home,
        R.drawable.mv_backdrop_aladdin,
        R.drawable.mv_backdrop_lion_king,
        R.drawable.mv_backdrop_alita,
        R.drawable.mv_backdrop_your_name,
        R.drawable.mv_backdrop_five_feet_apart,
        R.drawable.mv_backdrop_marlina,
        R.drawable.mv_backdrop_two_blue_stripes,
        R.drawable.mv_backdrop_fall_in_love_first_kiss
    )

    private val movieGenre = arrayOf(
        "Comedy, Thriller, Drama",
        "Action, Adventure, Science Fiction",
        "Comedy, Romance, Family",
        "Adventure, Family",
        "Action, Science Fiction, Adventure",
        "Romance, Animation, Drama",
        "Romance, Drama",
        "Thriller, Drama, Western",
        "Drama",
        "Romance, Comedy"
    )

    private val movieDuration = arrayOf(
        "2h 13m",
        "2h 9m",
        "2h 8m",
        "1h 58m",
        "2h 2m",
        "1h 46m",
        "1h 56m",
        "1h 33m",
        "1h 53m",
        "2h 3m"
    )

    private val movieOriginalLanguage = arrayOf(
        "Korean",
        "English",
        "English",
        "English",
        "English",
        "Japanese",
        "English",
        "Indonesian",
        "Indonesian",
        "Chinese"
    )

    private val movieRating = arrayOf(
        "85%",
        "75%",
        "71%",
        "72%",
        "70%",
        "86%",
        "82%",
        "71%",
        "74%",
        "63%"
    )

    val getMovies: ArrayList<Movie>
        get() {
            val list = arrayListOf<Movie>()
            for (position in movieId.indices) {
                val movie = Movie(
                    movieId[position],
                    movieReleaseDate[position],
                    movieTitle[position],
                    movieSummary[position],
                    moviePoster[position],
                    movieBackdropPoster[position],
                    movieGenre[position],
                    movieDuration[position],
                    movieOriginalLanguage[position],
                    movieRating[position]
                )
                list.add(movie)
            }
            return list
        }
}