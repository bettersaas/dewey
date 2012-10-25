package common.util;

import org.apache.oro.text.regex.*;

import common.util.string.TelNumberParser;
/**
 * 表达式检查类
 * 包括身份证件号码,电子邮件地址，手机号码，邮政编码，电话号码等常见的表达式格式检查
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author qiaohua 20040717
 *
 * @version 1.0
 */
public class ExpressionChecker
{
  /**
   * 匹配对象
   */
	public static PatternMatcher MATCHER = null;

  /**
   * 身份证模板
   */
  private static Pattern _oIDPattern  = null;

  /**
   * 电子邮件模板
   */
  private static Pattern _oEmailPattern = null ;

  /**
   * 手机号码模板
   */
  private static Pattern _oMobilePattern = null ;

  /**
   * 邮政编码模板
   */
  private static Pattern _oPostCodePattern = null;

  private static Pattern _oStackTraceLinePattern = null;

  /**
   * 静态初始化
   */
  static {
    _oPostCodePattern = createPattern ("[1-9]{1}[0-9]{5}" );
    _oMobilePattern   = createPattern ("(13|013)[0-9]{9}" );
    _oIDPattern = createPattern ("[0-9]{15}([0-9]{2}[0-9Xx]){0,1}" );
    _oEmailPattern = createPattern ("[\\w.-]+@([0-9a-z][\\w-]+\\.)+[a-z]{2,3}" );
    _oStackTraceLinePattern = createPattern ("\\tat (\\w+\\.)*((\\w+)|(\\<(cl)?init\\>))((\\(Unknown Source\\))|(\\(\\w+\\.java:[0-9]+\\)))");
    MATCHER = new Perl5Matcher();
  }

  /**
   * 是否符合异常堆栈信息行格式
   * @param inLine String
   * @return boolean
   */
  public static boolean isStackTraceLine( String inLine )
  {
    return isValid ( inLine , _oStackTraceLinePattern );
  }

  /**
   * 创建模板对象
   * @param inPattern String 模板表达式
   * @return Pattern 模板对象
   * @throws java.lang.IllegalArgumentException 错误的模板表达式
   */
  private static Pattern createPattern( String inPattern )
  {
    try {
      return new Perl5Compiler().compile( inPattern );
    }
    catch (Exception ex) {
      throw new java.lang.IllegalArgumentException ("Incorrect Pattern :" + inPattern );
    }
  }

  /**
   * 是否符合电话号码格式
   * @param inTelNumber String 电话号码
   * @return boolean true 正确<b/r>
   *                false 错误
   */
  public static boolean isTelNumber( String inTelNumber )
  {
    return TelNumberParser.isValid( inTelNumber );
  }

  /**
   * 是否符合邮政编码格式
   * @param inPostCode String
   * @return boolean
   */
  public static boolean isPostCode( String inPostCode )
  {
    return isValid( inPostCode , _oPostCodePattern );
  }

  /**
   * 是否符合手机号码格式
   * @param inMobile String
   * @return boolean
   */
  public static boolean isMobile ( String inMobile )
  {
    return isValid( inMobile , _oMobilePattern );
  }

  /**
   * 是否符合身份证号码格式
   * @param inID String
   * @return boolean
   */
  public static boolean isID ( String inID )
  {
    return isValid( inID , _oIDPattern );
  }

  /**
   * 是否符合电子邮件地址格式
   * @param inEmail String
   * @return boolean
   */
  public static boolean isEmail( String inEmail )
  {
    return isValid( inEmail , _oEmailPattern );
  }
  /**
   * 是否负荷给定的规则表达式格式
   * @param inExpression String
   * @param inPattern Pattern
   * @return boolean
   */
  private static boolean isValid( String inExpression , Pattern inPattern )
  {
     boolean rsbl=false;
    if ( inExpression != null && inExpression != null && inPattern != null )
    {
      try{
        //long start=(new java.util.Date()).getTime();
      Perl5Matcher perMatcher=new Perl5Matcher();
        rsbl=perMatcher.matches(inExpression, inPattern);
       // long end=(new java.util.Date()).getTime();
       // System.out.println("to checkeID used : "+(end-start));
      return rsbl;
      }catch(Exception e)  {
           return false;
      }
      //return MATCHER.matches( inExpression , inPattern );
    }
    else
    {
        return false ;
    }
  }

  /**
   * 是否符合给定的规则表达式格式
   * @param inExpression String
   * @param inPattern String
   * @return boolean
   */
  public static boolean isValid(String inExpression , String inPattern)
  {
    if ( inExpression != null && inPattern != null )
    {
      try {
        Pattern pattern = new Perl5Compiler().compile( inPattern );
        return isValid( inExpression , pattern ) ;
      }
      catch (Exception ex) {
        return false;
      }
    }
    else
    {
        return false ;
    }
  }
}
