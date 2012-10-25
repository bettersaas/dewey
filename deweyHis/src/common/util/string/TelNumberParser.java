package common.util.string;

import org.apache.oro.text.regex.*;


/**
 *
 * <p>Title:电话号码解析器 </p>
 * <p>Description:解析电话号码，包括国际国内等格式 </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * @author qiaohua
 * @version 1.0
*  建议我们的电话号码保存在DB中的格式采用国际格式：<br>
*  +86-755-82262888x7788            <br>
*
* 说明： <br>
* （1）国家代码、区号、电话号码间用“-”（连字号/减号）分格，<br>
*      电话号码和分机间用“x”分格                           <br>
* （2）电话号码间可以有空格分格，但国家码内、区号内不许有分格符号<br>
* （3）个险、产险DB中的电话号码字段为varchar(50)，可以容纳这种格式<br>
*<br>
* 简单说明E.123：                    <br>
* 电话号码格式分为国际和国内两种写法 <br>
* 国际格式：                   <br>
*  +86 755 8226 2888 ext. 7788 <br>
*   +86 138 1234 5678          <br>
* 国内格式：                   <br>
*  (0755)8226 2888 ext. 7788   <br>
*   0138 1234 5678             <br>
 */

public class TelNumberParser {
  public TelNumberParser( ) {
    this( COUNTRY_PREFIX,AREA_PREFIX,NUMBER_PREFIX,EXTENSION_PREFIX );
  }

  public TelNumberParser(String inCountryPrefix ,
                         String inAreaPrefix ,
                         String inNumberPrefix ,
                         String inExtensionPrefix)
  {
    _sCountryPrefix = inCountryPrefix ;
    _sAreaPrefix    = inAreaPrefix ;
    _sNumberPrefix  = inNumberPrefix ;
    _sExtensionPrefix = inExtensionPrefix ;

    _oPattern = createPattern ( _sCountryPrefix ,_sAreaPrefix ,_sNumberPrefix ,_sExtensionPrefix  );
  }

  /**
   * 构建模板
   * @param inCountryPrefix String
   * @param inAreaPrefix String
   * @param inNumberPrefix String
   * @param inExtensionPrefix String
   * @return Pattern
   * 电话号码内部部分排列格式规则如下
   * C - CountryCode    +
   * A - AreaCode       -
   * N - NumberCode     -
   * E - ExtensionCode  x
   * 符合以下型式则表示正确
   * +C-A-NxE
   * +C-A-N
   *    A-NxE
   *    A-N
   *      NxE
   *      N
   */
  private static Pattern createPattern( String inCountryPrefix ,
                                        String inAreaPrefix ,
                                        String inNumberPrefix ,
                                        String inExtensionPrefix  )
  {

    if ( inCountryPrefix == null || inAreaPrefix ==null || inNumberPrefix == null || inExtensionPrefix == null )
    {
      throw new java.lang.NullPointerException("the Prefix Parameter(s) can't be null.");
    }

    String sPattern = new String("((\\"+inCountryPrefix+NUMBER_PATTERN+inAreaPrefix+NUMBER_PATTERN+"|"+NUMBER_PATTERN+")"+inNumberPrefix +")?(\\d+([ ]{0,1}\\d+)+)("+inExtensionPrefix + NUMBER_PATTERN+")?");

    try {
      return new Perl5Compiler().compile( sPattern );
    }
    catch (Exception ex) {
      throw new java.lang.IllegalArgumentException("Incorrect Pattern "+ sPattern +"|"+ex.getMessage());
    }

  }

  /**
   * 格式化电话号码
   * @param inTelNumber TelNumber 格式化对象
   * @return String 电话号码
   */
  public String formatTelNumber( TelNumber inTelNumber )
  {
    return format( inTelNumber , _sCountryPrefix ,_sAreaPrefix ,_sNumberPrefix , _sExtensionPrefix );
  }
  /**
   * 格式化电话号码
   * @param inTelNumber TelNumber
   * @return String
   */
  public static String format(TelNumber inTelNumber)
  {
    return format( inTelNumber , COUNTRY_PREFIX, AREA_PREFIX,NUMBER_PREFIX,EXTENSION_PREFIX);
  }
  /**
   * 格式化 TelNumber对象
   * @param inTelNumber TelNumber TelNumber对象
   * @param inCountryPrefix String 国家前缀
   * @param inAreaPrefix String 区号前缀
   * @param inNumberPrefix String 总机前缀
   * @param inExtensionPrefix String 分机前缀
   * @return String 格式正确将放回CANE型式的表达式，
   *                格式错误返回空
   */
  private static String format ( TelNumber inTelNumber ,
                                 String inCountryPrefix ,
                                 String inAreaPrefix ,
                                 String inNumberPrefix ,
                                 String inExtensionPrefix )
  {

       if ( inTelNumber == null || inTelNumber.getNumber() == null )
       {
         return null;
       }

       StringBuffer sb = new StringBuffer();

       if ( inTelNumber.getCountry() != null )
       {
         sb.append( inCountryPrefix );
         sb.append( inTelNumber.getCountry() );

         if ( inTelNumber.getArea() != null )
         {
           sb.append( inAreaPrefix );
           sb.append( inTelNumber.getArea() );
           sb.append( inNumberPrefix );
         }
         else
         {
             return null;
         }
       }
       else if ( inTelNumber.getArea() != null )
       {
           sb.append( inTelNumber.getArea() );
           sb.append( inNumberPrefix );
       }

       sb.append( inTelNumber.getNumber()  );

       if ( inTelNumber.getExtension() != null )
       {
         sb.append( inExtensionPrefix );
         sb.append( inTelNumber.getExtension() );
       }

       return sb.toString();
  }
  /**
   * 返回国家前缀
   * @return String
   */
  public String getCountryPrefix ()
  {
    return _sCountryPrefix ;
  }

  /**
   * 返回区号前缀
   * @return String
   */
  public String getAreaPrefix ()
  {
    return _sAreaPrefix ;
  }

  /**
   * 返回总机前缀
   * @return String
   */
  public String getNumberPrefix ()
  {
    return _sNumberPrefix ;
  }

  /**
   * 返回分机前缀
   * @return String
   */
  public String getExtensionPrefix()
  {
    return _sExtensionPrefix ;
  }


  /**
   * 默认国家前缀
   */
  public static final String COUNTRY_PREFIX   = "+";

  /**
   * 默认地区前缀
   */
  public static final String AREA_PREFIX      = "-";

  /**
   * 默认总机前缀
   */
  public static final String NUMBER_PREFIX    = "-";

  /**
   * 默认分机前缀
   */
  public static final String EXTENSION_PREFIX = "x";

  /**
   * 数字正则表达式
   */
  private static final String NUMBER_PATTERN = "\\d+";

  /**
   * 自定义国家前缀
   */
  private String _sCountryPrefix = COUNTRY_PREFIX;

  /**
   * 自定义地区前缀
   */
  private String _sAreaPrefix = AREA_PREFIX;

  /**
   * 自定义总机前缀
   */
  private String _sNumberPrefix = NUMBER_PREFIX;

  /**
   * 自定义分机前缀
   */
  private String _sExtensionPrefix = EXTENSION_PREFIX;

  /**
   * 自定义电话模板
   */
  private Pattern _oPattern = null;

  /**
   * 模板匹配对象
   */
  public static PatternMatcher MATCHER = new Perl5Matcher();

  /**
   * 默认电话号码模板
   */
  private static Pattern PATTERN = createPattern( COUNTRY_PREFIX ,AREA_PREFIX ,NUMBER_PREFIX ,EXTENSION_PREFIX  );

  /**
   *  判断电话号码是否格式正确
   * @param inNumber String 电话号码
   * @param inPattern Pattern 正则表达模板
   * @return boolean true 正确
   *                 false 错误
   */
  private static boolean isValid(String inNumber , Pattern inPattern)
  {
    boolean rsbl=false;
   if ( inNumber != null && !inNumber.equals("") && inPattern != null )
   {
     try{
       Perl5Matcher perMatcher=new Perl5Matcher();
         rsbl=perMatcher.matches(inNumber, inPattern);
       return rsbl;
     }catch(Exception e){
       return false;
     }
   }
   else
   {
     return false;
   }
  }

  /**
   * 判断电话号码格式是否正确
   * @param inNumber String
   * @return boolean true 正确<br/>
   *                 false错误
   * 使用默认正则表达模板
   */
  public static boolean isValid(String inNumber )
  {
   return isValid ( inNumber ,  PATTERN);
  }

  /**
   * 判断电话号码格式是否正确
   * @param inNumber String
   * @return boolean true 正确<br/>
   *                 false 错误
   * 使用自定义正则模板
   */
  public boolean isValidNumber(String inNumber )
  {
    return isValid ( inNumber , _oPattern );
  }

  /**
   * 解析电话号码，返回对象TelNumber
   * @param inNumber String
   * @throws TelNumberParsingEx
   * @return TelNumber
 * @throws Exception 
   */
  public TelNumber parseNumber( String inNumber ) throws Exception
  {
    return parse ( inNumber ,_sCountryPrefix , _sAreaPrefix , _sNumberPrefix, _sExtensionPrefix ,_oPattern );
  }

  /**
   * 解析电话号码，返回对象TelNumber
   * @param inNumber String
   * @throws TelNumberParsingEx
   * @return TelNumber
 * @throws Exception 
   */
  public static TelNumber parse( String inNumber ) throws Exception
  {
    return parse ( inNumber ,COUNTRY_PREFIX,AREA_PREFIX ,NUMBER_PREFIX,EXTENSION_PREFIX ,PATTERN );
  }

  /**
   * 解析电话号码，如果正确，则返回TelNumber对象
   * 将电话号码的C A N E分别解析出来放入TelNumber对象中
   *
   * @param inNumber String 需要解析的电话号码
   * @param inCountryPrefix String 国家前缀
   * @param inAreaPrefix String 区号前缀
   * @param inNumberPrefix String 总机前缀
   * @param inExtension String 分机前缀
   * @param inPattern Pattern 正则表达式模板
   * @throws TelNumberParsingEx 电话号码解析异常
   * @return TelNumber 电话号码对象
 * @throws Exception 
   */
  private static TelNumber parse(String inNumber ,
                                String inCountryPrefix,
                                String inAreaPrefix ,
                                String inNumberPrefix ,
                                String inExtension,
                                Pattern inPattern ) throws Exception {
   if ( isValid( inNumber ,inPattern ))
   {
     TelNumber oTelNumber = new TelNumber();

     int iArea = 0;
     int iNumber = 0;
     int iExtension = 0;
     String sNumber = inNumber ;

     //如果存在国家码
     if ( sNumber.startsWith( inCountryPrefix ) && (iArea = sNumber.indexOf( inAreaPrefix )) > 0)
     {
         oTelNumber.setCountry( sNumber.substring( inCountryPrefix.length() , iArea ) );
         sNumber = sNumber.substring( iArea + inAreaPrefix.length() ,sNumber.length() );
     }

     if ( (iNumber = sNumber.indexOf( inNumberPrefix ))>0 )
     {
         oTelNumber.setArea( sNumber.substring( 0  , iNumber));
         sNumber = sNumber.substring( iNumber + inNumberPrefix.length()  , sNumber.length() );
     }

     if ( (iExtension = sNumber.indexOf( inExtension )) > 0)
     {
         oTelNumber.setNumber( sNumber.substring(0, iExtension ) );
         oTelNumber.setExtension( sNumber.substring( iExtension  + inExtension.length() , sNumber.length() ));
     }
     else
     {
         oTelNumber.setNumber( sNumber );
     }

     return oTelNumber;
   }
   else
   {
       throw new Exception("Incorrect Tel Number Format" + inNumber);
   }

  }
}
