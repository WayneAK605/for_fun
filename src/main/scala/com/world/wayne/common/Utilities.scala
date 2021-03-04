package com.world.wayne.common

import java.util.Scanner
import scala.util.matching.Regex

object Utilities {
  def screenInput(sc: Scanner, prompt: String, userPromptRegexPattern: Regex): String ={

    var loop = true
    var userInput: String = null

    while(loop) {
      print(s"$prompt [${userPromptRegexPattern.toString()}]==> ")

      userPromptRegexPattern.findFirstIn(sc.next()) match {
        case Some(f) => {
          loop = false
          userInput = f
        }
        case None => loop = true
      }
    }
    userInput
  }

  implicit class roundingEnhance(n: Double) {
    def roundTwoDecimal: Double = {
      Math.round(n * 100.0) / 100.0
    }
  }
}
