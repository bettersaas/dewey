package common.util.string;

/**
 * 身份证号码类. 
 * 该类根据国家标准, 对GB11643-1989和GB11643-1999两种版本的身份证规则做了实现.
 * 可以用于两种版本间的转换. 同时与LBS使用之身份证相关算法兼容. 
 * 
 * 具体规则参考国家标准GB11643-1999. GB11643-1999自实施之日起替代GB11643-1989.
 */
public final class CitizenIdNumber {

  /**
   * 18位身份证号码.
   */
  private String id;
    
  /**
   * 是否有效
   */
  private boolean valid;
  
  /**
   * 各位的加权因子
   */
  private static final int[] FACTORY= new int[] {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1};
  
  /**
   * 身份证号码的解析顺序为 从左向右
   * <li>长度必须为18位</li>
   * <li>最后一位为字母或者数字, 其他位必须为数字<li>
   */
  //private static final Pattern digitChecker_18= Pattern.compile( "^\\d{17}?\\w$");
  
  /**
   * 15位身份证必须全为数字
   */
  //private static final Pattern digitChecker_15= Pattern.compile( "^\\d{15}$");
  
  public CitizenIdNumber(String id) {
    this.id= id;
    // 18位则检查校验码
    if ( this.id.length()== 18 && this.getCheckValue()== this.id.charAt( 17)) {
    	this.valid= true;
    }else if ( this.id.length()== 15) {
    	// 是15位字符串, 则转换为18位  610324198210102011
    	// 1、年由两位扩展为四位
		int yy= (this.id.charAt( 6)- 48)*10+ this.id.charAt(7)-48;
		yy= (yy==0?2000:(1900+yy));
		this.id= id.substring( 0, 6)+ String.valueOf( yy)+ id.substring( 8, 15);
		// 2、根据前17为计算18位的校验值
		this.id= this.id+ this.getCheckValue();
		this.valid= true;
    }else {
      this.valid= false;
    }
  }
  
  /**
   * 如下情况身份证号码视为无效.
   * <li>长度不为15或18位</li>
   * <li>18位身份证号校验位不对</li>
   * <li>18位身份证号前17位必须为数字, 而15位身份证号必须全部为数字</li>
   * 对于身份证中的日期等, 没有做校验.
   * @return true, 身份证号码有效; false, 身份证号码无效
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
   * 计算校验值
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