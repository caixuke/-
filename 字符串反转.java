// 1.最简单的方法：
public static String reverse1(String str)
{
   return new StringBuffer(str).reverse().toString();
}
// 2.最常用的方法：
public static String reverse3(String s)
 { 
   char[] array = s.toCharArray(); 
  String reverse = "";  //注意这是空串，不是null
   for (int i = array.length - 1; i >= 0; i--) 
   reverse += array[i]; 
   return reverse; 
  } 
// 3.常用方法的变形：
 public static String reverse2(String s)
{ 
  int length = s.length(); 
   String reverse = "";  //注意这是空串，不是null
   for (int i = 0; i < length; i++) 
    reverse = s.charAt(i) + reverse;//在字符串前面连接，  而非常见的后面
   return reverse; 
  } 
// 4.C语言中常用的方法：
 public static String reverse5(String orig)
{ 
  char[] s = orig.toCharArray(); 
  int n = s.length - 1; 
  int halfLength = n / 2; 
  for (int i = 0; i <= halfLength; i++) { 
    char temp = s[i]; 
   s[i] = s[n - i]; 
   s[n - i] = temp; 
   } 
   return new String(s);  //知道  char数组和String相互转化
  } 
 