package ir.alirezamehri.bmicalculator

class CalculateBmi {

    fun computing(weight: Int, height: Int): Double {
        val bmi = weight / Math.pow((height / 100).toDouble(), 2.0);
        return bmi
    }

    fun getResult(bmi: Double): String {
        if (bmi >= 25.0) {
            return "اضافه وزن";
        } else if (bmi > 18.5) {
            return "عادی";
        } else {
            return "کمبود وزن";
        }
    }

    fun getInterpretation(bmi: Double): String {
        if (bmi >= 25.0) {
            return "وزن بدن شما بالاتر از حد طبیعی است. سعی کنید بیشتر ورزش کنید.";
        } else if (bmi >= 18.5) {
            return "شما وزن طبیعی دارید. آفرین!";
        } else {
            return "وزن بدن شما کمتر از حد طبیعی است. می توانید کمی بیشتر بخورید.";
        }
    }

}