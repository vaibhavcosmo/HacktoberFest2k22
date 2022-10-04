package com.example.test
import kotlin.random.Random
object Constants{
    fun getQuestions():ArrayList<Question>{
        val questionlistprimary=ArrayList<Question>()
        val questionsList = ArrayList<Question>()

        val que1 = Question(1,"Rishte me hum tumhare baap lagte hai",
            "Dil","Shahenshah","Karan Arjun","DDLJ",
        2)
        questionlistprimary.add(que1)

        val que2 = Question(2,"My name is Khan and I am not terrorist",
            "movie 26/11","Shahenshah","Fanaa","My name is Khan",
            4)
        questionlistprimary.add(que2)

        val que3 = Question(3,"Kitne aadmi the",
            "Dil","Shahenshah","Sholay","DDLJ",
            3)
        questionlistprimary.add(que3)

        val que4 = Question(4,"Kutte,Kamine mai tera khoon pee jaunga",
            "Karan Arjun","Yadon ki baarat","Fanaa","My name is Khan",
            2)
        questionlistprimary.add(que4)

        val que5=Question(5,"Ek baar jo maine commitment kardi toh mai apne aap ki bhi nahi sunta",
        "wanted","ready","bajrangi bhaijaan","antim the final truth",
        1)
        questionlistprimary.add(que5)

        val que6=Question(6,"",
            "","","","",
            1)
        questionlistprimary.add(que5)

        val que7=Question(7,"Ek baar jo maine commitment kardi toh mai apne aap ki bhi nahi sunta",
            "wanted","ready","bajrangi bhaijaan","antim the final truth",
            1)
        questionlistprimary.add(que5)

        val que8=Question(8,"Ek baar jo maine commitment kardi toh mai apne aap ki bhi nahi sunta",
            "wanted","ready","bajrangi bhaijaan","antim the final truth",
            1)
        questionlistprimary.add(que5)

        val que9=Question(9,"Ek baar jo maine commitment kardi toh mai apne aap ki bhi nahi sunta",
            "wanted","ready","bajrangi bhaijaan","antim the final truth",
            1)
        questionlistprimary.add(que5)

        val que10=Question(10,"Ek baar jo maine commitment kardi toh mai apne aap ki bhi nahi sunta",
            "wanted","ready","bajrangi bhaijaan","antim the final truth",
            1)
        questionlistprimary.add(que5)

        val que11=Question(11,"Ek baar jo maine commitment kardi toh mai apne aap ki bhi nahi sunta",
            "wanted","ready","bajrangi bhaijaan","antim the final truth",
            1)
        questionlistprimary.add(que5)


        var amp=IntArray(5){Random.nextInt(11)}.asList()
        for (i in amp){
            questionsList.add(questionlistprimary[i])
        }
        return questionsList
    }
}