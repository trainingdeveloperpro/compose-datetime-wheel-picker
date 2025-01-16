package dev.darkokoa.datetimewheelpicker.core.format

import androidx.compose.ui.text.intl.Locale

enum class DateOrder(val fields: List<DateField>) {
  DMY(listOf(DateField.DAY, DateField.MONTH, DateField.YEAR)),   // Most European countries
  MDY(listOf(DateField.MONTH, DateField.DAY, DateField.YEAR)),   // USA
  YMD(listOf(DateField.YEAR, DateField.MONTH, DateField.DAY));   // East Asian countries, ISO

  // https://en.wikipedia.org/wiki/List_of_date_formats_by_country
  companion object {
    fun match(locale: Locale): DateOrder {
      return when {
        locale.language == "en" && locale.region in listOf("US", "PH", "FM", "PW", "CA", "KY", "GU", "AS", "PR", "VI", "MP", "MH", "BS", "BZ", "LR", "TG", "KE", "GH")  -> MDY
        locale.language in listOf("zh", "ja", "ko", "hu", "mn", "lt", "dz") -> YMD
        else -> DMY
      }
    }
  }
}