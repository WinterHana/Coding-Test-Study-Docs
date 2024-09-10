public class StringClassBasicFunc {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "apple";
        String str3 = "banana";

        boolean isEqual = str1.equals(str2);
        boolean isNotEqual = str3.equals(str1);

        String str = "apple";
        int length = str.length();

        String str4 = "apple";
        String upperStr = str4.toUpperCase();
        String str5 = "APPLE";
        String lowerStr = str.toLowerCase();

        String str6 = "apple";
        int index = str6.indexOf("p");
        int notFound = str6.indexOf("z");

        String str7 = "apple";
        String subStr1 = str7.substring(1);//pple
        String subStr2 = str7.substring(1,3);//pp

        String str8 = "apple";
        String replacedStr = str8.replace('p','b');

        String str9 = " apple ";
        String trimmedStr = str9.trim();

        String str10 = "apple";
        String str11 = "banana";
        int comparison = str10.compareTo(str11);

        String str12 = "apple,banana,pear";
        String[] fruits = str12.split(",");

        String str13 = "apple";
        boolean contains = str13.indexOf("pp") != -1;

        String str14 = "apple";
        boolean contains2 = str.contains("pp");

        String str15 = "apple";
        char ch = str15.charAt(1);//p

        String str16 = "apple";
        boolean startsWith = str16.startsWith("ap");

        String str17 = "apple";
        boolean endsWith = str17.endsWith("le");


        String str18 = "apple";
        String str19 = "apple";
        String str20 = "banana";

        boolean isEqual2 = str18.equals(str19);
        boolean isNotEqual2 = str18.equals(str20);

        String str21 = "apple";
        int str18length = str21.length();

        String str22 = "apple";
        String str22UpperCase = str22.toUpperCase();
        String str23 = "APPLE";
        String str23LowerCase = str23.toLowerCase();

        String str24 = "apple";
        int indexOfStr24 = str24.indexOf("p");
        int indexOfStr24z = str24.indexOf("z");//얘가 -1이면 포함하지 않는다.

        String str25 = "apple";
        String subString25 = str25.substring(1,3);//pp
        String subString25two = str25.substring(1);//pple

        String str26 = "apple";
        String replacedStr26 = str26.replace("p","b");

        String str27 = "apple";
        String trimmedStr27 = str27.trim();

        String str28 = "apple";
        String str29 = "banana";
        //사전식순서
        int sortedDicStr28 = str28.compareTo(str29);// -1이면 apple이 앞이라는거. 객체기준으로 -1이면 앞 0이면 같음 1이면 뒤
        String str30 = "apple";
        String[] splitedStr30 = str30.split(",");
        String str31 = "apple";
        boolean containsStr31 = str31.contains("pp");

        String str32 = "apple";
        char ch32 = str32.charAt(1);

        String str33 = "apple";
        boolean startWith33 = str33.startsWith("app");
        boolean endsWith33 = str33.endsWith("pple");


    }//End Of Main
}
