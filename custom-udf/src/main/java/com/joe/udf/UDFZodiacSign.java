package com.joe.udf;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 根据日期计算星座的UDF
 */
@Description(name = "zodiac",
        value = "_FUNC_(date) from the input date string or separate month and day arugments,returns the sign of the Zodiac.",
        extended = "Example:\n"
                + ">SELECT _FUNC_(date string) from src;\n"
                + ">SELECT _FUNC_(month,day) from src;")
public class UDFZodiacSign extends UDF {
    private SimpleDateFormat dateFormat;

    public UDFZodiacSign() {
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String evaluate(Date birthDay) {
        return this.evaluate(birthDay.getMonth() + 1, birthDay.getDate());
    }

    public String evaluate(String birthDay) {
        Date date = null;
        try {
            date = this.dateFormat.parse(birthDay);
        } catch (Exception ex) {
            return null;
        }

        return this.evaluate(date.getMonth() + 1, date.getDate());
    }

    public String evaluate(Integer month, Integer day) {
        if (month == 1) {
            if (day <= 20) {
                return "摩羯座";
            } else {
                return "水瓶座";
            }
        }

        if (month == 2) {
            if (day <= 19) {
                return "水瓶座";
            } else {
                return "双鱼座";
            }
        }

        if (month == 3) {
            if (day <= 20) {
                return "双鱼座";
            } else {
                return "白羊座";
            }
        }

        if (month == 4) {
            if (day <= 20) {
                return "白羊座";
            } else {
                return "金牛座";
            }
        }

        if (month == 5) {
            if (day <= 21) {
                return "金牛座";
            } else {
                return "双子座";
            }
        }
        if (month == 6) {
            if (day <= 21) {
                return "双子座";
            } else {
                return "巨蟹座";
            }
        }
        if (month == 7) {
            if (day <= 22) {
                return "巨蟹座";
            } else {
                return "狮子座";
            }
        }
        if (month == 8) {
            if (day <= 23) {
                return "狮子座";
            } else {
                return "处女座";
            }
        }
        if (month == 9) {
            if (day <= 23) {
                return "处女座";
            } else {
                return "天秤座";
            }
        }
        if (month == 10) {
            if (day <= 23) {
                return "天秤座";
            } else {
                return "天蝎座";
            }
        }
        if (month == 11) {
            if (day <= 22) {
                return "天蝎座";
            } else {
                return "天蝎座";
            }
        }
        if (month == 12) {
            if (day <= 22) {
                return "天蝎座";
            } else {
                return "摩羯座";
            }
        }


        return null;
    }
}

