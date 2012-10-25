package common.util.string;

import org.apache.oro.text.regex.*;


/**
 *
 * <p>Title:�绰��������� </p>
 * <p>Description:�����绰���룬�������ʹ��ڵȸ�ʽ </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * @author qiaohua
 * @version 1.0
*  �������ǵĵ绰���뱣����DB�еĸ�ʽ���ù��ʸ�ʽ��<br>
*  +86-755-82262888x7788            <br>
*
* ˵���� <br>
* ��1�����Ҵ��롢���š��绰������á�-�������ֺ�/���ţ��ָ�<br>
*      �绰����ͷֻ����á�x���ָ�                           <br>
* ��2���绰���������пո�ָ񣬵��������ڡ������ڲ����зָ����<br>
* ��3�����ա�����DB�еĵ绰�����ֶ�Ϊvarchar(50)�������������ָ�ʽ<br>
*<br>
* ��˵��E.123��                    <br>
* �绰�����ʽ��Ϊ���ʺ͹�������д�� <br>
* ���ʸ�ʽ��                   <br>
*  +86 755 8226 2888 ext. 7788 <br>
*   +86 138 1234 5678          <br>
* ���ڸ�ʽ��                   <br>
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
   * ����ģ��
   * @param inCountryPrefix String
   * @param inAreaPrefix String
   * @param inNumberPrefix String
   * @param inExtensionPrefix String
   * @return Pattern
   * �绰�����ڲ��������и�ʽ��������
   * C - CountryCode    +
   * A - AreaCode       -
   * N - NumberCode     -
   * E - ExtensionCode  x
   * ����������ʽ���ʾ��ȷ
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
   * ��ʽ���绰����
   * @param inTelNumber TelNumber ��ʽ������
   * @return String �绰����
   */
  public String formatTelNumber( TelNumber inTelNumber )
  {
    return format( inTelNumber , _sCountryPrefix ,_sAreaPrefix ,_sNumberPrefix , _sExtensionPrefix );
  }
  /**
   * ��ʽ���绰����
   * @param inTelNumber TelNumber
   * @return String
   */
  public static String format(TelNumber inTelNumber)
  {
    return format( inTelNumber , COUNTRY_PREFIX, AREA_PREFIX,NUMBER_PREFIX,EXTENSION_PREFIX);
  }
  /**
   * ��ʽ�� TelNumber����
   * @param inTelNumber TelNumber TelNumber����
   * @param inCountryPrefix String ����ǰ׺
   * @param inAreaPrefix String ����ǰ׺
   * @param inNumberPrefix String �ܻ�ǰ׺
   * @param inExtensionPrefix String �ֻ�ǰ׺
   * @return String ��ʽ��ȷ���Ż�CANE��ʽ�ı��ʽ��
   *                ��ʽ���󷵻ؿ�
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
   * ���ع���ǰ׺
   * @return String
   */
  public String getCountryPrefix ()
  {
    return _sCountryPrefix ;
  }

  /**
   * ��������ǰ׺
   * @return String
   */
  public String getAreaPrefix ()
  {
    return _sAreaPrefix ;
  }

  /**
   * �����ܻ�ǰ׺
   * @return String
   */
  public String getNumberPrefix ()
  {
    return _sNumberPrefix ;
  }

  /**
   * ���طֻ�ǰ׺
   * @return String
   */
  public String getExtensionPrefix()
  {
    return _sExtensionPrefix ;
  }


  /**
   * Ĭ�Ϲ���ǰ׺
   */
  public static final String COUNTRY_PREFIX   = "+";

  /**
   * Ĭ�ϵ���ǰ׺
   */
  public static final String AREA_PREFIX      = "-";

  /**
   * Ĭ���ܻ�ǰ׺
   */
  public static final String NUMBER_PREFIX    = "-";

  /**
   * Ĭ�Ϸֻ�ǰ׺
   */
  public static final String EXTENSION_PREFIX = "x";

  /**
   * ����������ʽ
   */
  private static final String NUMBER_PATTERN = "\\d+";

  /**
   * �Զ������ǰ׺
   */
  private String _sCountryPrefix = COUNTRY_PREFIX;

  /**
   * �Զ������ǰ׺
   */
  private String _sAreaPrefix = AREA_PREFIX;

  /**
   * �Զ����ܻ�ǰ׺
   */
  private String _sNumberPrefix = NUMBER_PREFIX;

  /**
   * �Զ���ֻ�ǰ׺
   */
  private String _sExtensionPrefix = EXTENSION_PREFIX;

  /**
   * �Զ���绰ģ��
   */
  private Pattern _oPattern = null;

  /**
   * ģ��ƥ�����
   */
  public static PatternMatcher MATCHER = new Perl5Matcher();

  /**
   * Ĭ�ϵ绰����ģ��
   */
  private static Pattern PATTERN = createPattern( COUNTRY_PREFIX ,AREA_PREFIX ,NUMBER_PREFIX ,EXTENSION_PREFIX  );

  /**
   *  �жϵ绰�����Ƿ��ʽ��ȷ
   * @param inNumber String �绰����
   * @param inPattern Pattern ������ģ��
   * @return boolean true ��ȷ
   *                 false ����
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
   * �жϵ绰�����ʽ�Ƿ���ȷ
   * @param inNumber String
   * @return boolean true ��ȷ<br/>
   *                 false����
   * ʹ��Ĭ��������ģ��
   */
  public static boolean isValid(String inNumber )
  {
   return isValid ( inNumber ,  PATTERN);
  }

  /**
   * �жϵ绰�����ʽ�Ƿ���ȷ
   * @param inNumber String
   * @return boolean true ��ȷ<br/>
   *                 false ����
   * ʹ���Զ�������ģ��
   */
  public boolean isValidNumber(String inNumber )
  {
    return isValid ( inNumber , _oPattern );
  }

  /**
   * �����绰���룬���ض���TelNumber
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
   * �����绰���룬���ض���TelNumber
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
   * �����绰���룬�����ȷ���򷵻�TelNumber����
   * ���绰�����C A N E�ֱ������������TelNumber������
   *
   * @param inNumber String ��Ҫ�����ĵ绰����
   * @param inCountryPrefix String ����ǰ׺
   * @param inAreaPrefix String ����ǰ׺
   * @param inNumberPrefix String �ܻ�ǰ׺
   * @param inExtension String �ֻ�ǰ׺
   * @param inPattern Pattern ������ʽģ��
   * @throws TelNumberParsingEx �绰��������쳣
   * @return TelNumber �绰�������
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

     //������ڹ�����
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
