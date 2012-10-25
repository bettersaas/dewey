package common.util.string;

/**
 * ���֤������. 
 * ������ݹ��ұ�׼, ��GB11643-1989��GB11643-1999���ְ汾�����֤��������ʵ��.
 * �����������ְ汾���ת��. ͬʱ��LBSʹ��֮���֤����㷨����. 
 * 
 * �������ο����ұ�׼GB11643-1999. GB11643-1999��ʵʩ֮�������GB11643-1989.
 */
public final class CitizenIdNumber {

  /**
   * 18λ���֤����.
   */
  private String id;
    
  /**
   * �Ƿ���Ч
   */
  private boolean valid;
  
  /**
   * ��λ�ļ�Ȩ����
   */
  private static final int[] FACTORY= new int[] {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1};
  
  /**
   * ���֤����Ľ���˳��Ϊ ��������
   * <li>���ȱ���Ϊ18λ</li>
   * <li>���һλΪ��ĸ��������, ����λ����Ϊ����<li>
   */
  //private static final Pattern digitChecker_18= Pattern.compile( "^\\d{17}?\\w$");
  
  /**
   * 15λ���֤����ȫΪ����
   */
  //private static final Pattern digitChecker_15= Pattern.compile( "^\\d{15}$");
  
  public CitizenIdNumber(String id) {
    this.id= id;
    // 18λ����У����
    if ( this.id.length()== 18 && this.getCheckValue()== this.id.charAt( 17)) {
    	this.valid= true;
    }else if ( this.id.length()== 15) {
    	// ��15λ�ַ���, ��ת��Ϊ18λ  610324198210102011
    	// 1��������λ��չΪ��λ
		int yy= (this.id.charAt( 6)- 48)*10+ this.id.charAt(7)-48;
		yy= (yy==0?2000:(1900+yy));
		this.id= id.substring( 0, 6)+ String.valueOf( yy)+ id.substring( 8, 15);
		// 2������ǰ17Ϊ����18λ��У��ֵ
		this.id= this.id+ this.getCheckValue();
		this.valid= true;
    }else {
      this.valid= false;
    }
  }
  
  /**
   * ����������֤������Ϊ��Ч.
   * <li>���Ȳ�Ϊ15��18λ</li>
   * <li>18λ���֤��У��λ����</li>
   * <li>18λ���֤��ǰ17λ����Ϊ����, ��15λ���֤�ű���ȫ��Ϊ����</li>
   * �������֤�е����ڵ�, û����У��.
   * @return true, ���֤������Ч; false, ���֤������Ч
   * @since 1.0
   */
  public boolean isValid() {
    return this.valid;
  }
  
  /**
   * 
   * @return
   */
  public String getValue() {
    return this.id;
  }
 
  /**
   * ����У��ֵ
   * @return
   */
  private char getCheckValue() {
    int check_sum= 0;
    for ( int i=0; i<17; i++) {
      check_sum+= FACTORY[i]*( (int)this.id.charAt(i)-48);
    }
    check_sum= (12 - check_sum % 11) % 11;
    if ( check_sum== 10) {
      return 'X';
    }else {
      return (char)(check_sum+48);
    }
  }
  
  /**
   * 
   * @param args
   */
  public static void main( String[] args) {
    long start= System.currentTimeMillis();
    System.out.println(new CitizenIdNumber("210104781201281").isValid());
    System.out.println(new CitizenIdNumber("210104197812012819").isValid());
    System.out.println(new CitizenIdNumber("610324198210102013").isValid());
    System.out.println( "Time: "+ (System.currentTimeMillis()- start)+ "ms.");
  }
}