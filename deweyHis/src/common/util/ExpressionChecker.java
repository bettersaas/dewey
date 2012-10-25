package common.util;

import org.apache.oro.text.regex.*;

import common.util.string.TelNumberParser;
/**
 * ���ʽ�����
 * �������֤������,�����ʼ���ַ���ֻ����룬�������룬�绰����ȳ����ı��ʽ��ʽ���
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
   * ƥ�����
   */
	public static PatternMatcher MATCHER = null;

  /**
   * ���֤ģ��
   */
  private static Pattern _oIDPattern  = null;

  /**
   * �����ʼ�ģ��
   */
  private static Pattern _oEmailPattern = null ;

  /**
   * �ֻ�����ģ��
   */
  private static Pattern _oMobilePattern = null ;

  /**
   * ��������ģ��
   */
  private static Pattern _oPostCodePattern = null;

  private static Pattern _oStackTraceLinePattern = null;

  /**
   * ��̬��ʼ��
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
   * �Ƿ�����쳣��ջ��Ϣ�и�ʽ
   * @param inLine String
   * @return boolean
   */
  public static boolean isStackTraceLine( String inLine )
  {
    return isValid ( inLine , _oStackTraceLinePattern );
  }

  /**
   * ����ģ�����
   * @param inPattern String ģ����ʽ
   * @return Pattern ģ�����
   * @throws java.lang.IllegalArgumentException �����ģ����ʽ
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
   * �Ƿ���ϵ绰�����ʽ
   * @param inTelNumber String �绰����
   * @return boolean true ��ȷ<b/r>
   *                false ����
   */
  public static boolean isTelNumber( String inTelNumber )
  {
    return TelNumberParser.isValid( inTelNumber );
  }

  /**
   * �Ƿ�������������ʽ
   * @param inPostCode String
   * @return boolean
   */
  public static boolean isPostCode( String inPostCode )
  {
    return isValid( inPostCode , _oPostCodePattern );
  }

  /**
   * �Ƿ�����ֻ������ʽ
   * @param inMobile String
   * @return boolean
   */
  public static boolean isMobile ( String inMobile )
  {
    return isValid( inMobile , _oMobilePattern );
  }

  /**
   * �Ƿ�������֤�����ʽ
   * @param inID String
   * @return boolean
   */
  public static boolean isID ( String inID )
  {
    return isValid( inID , _oIDPattern );
  }

  /**
   * �Ƿ���ϵ����ʼ���ַ��ʽ
   * @param inEmail String
   * @return boolean
   */
  public static boolean isEmail( String inEmail )
  {
    return isValid( inEmail , _oEmailPattern );
  }
  /**
   * �Ƿ񸺺ɸ����Ĺ�����ʽ��ʽ
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
   * �Ƿ���ϸ����Ĺ�����ʽ��ʽ
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
