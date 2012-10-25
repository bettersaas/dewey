package common.util.string;

/**
 * <p>类名: 电话号码</p>
 * <p>描述: 存放电话号码，具体分：<br>
 * 国家码,地区码,具体号码,分机号<br></p>
 * <p>部门: 新科技部</p>
 * @version 1.0
 */

public class TelNumber {
  /**
   *   国家码
   */
  private String _Country = null;
  /**
   * 地区码
   */
  private String _Area = null;
  /**
   * 电话号码
   */
  private String _Number = null;
  /**
   * 分机号
   */
  private String _Extension = null;

  public TelNumber() {
  }
  /**
   * 设置国家码
   * @param inCountry  国家码，例如中国就是86
   */
  public void setCountry(String inCountry) {
    _Country= inCountry;
  }
  /**
   * 获取国家号码
   * @return 国家号码
   */
  public String getCountry() {
    return _Country;
  }
  /**
   * 设置地区号码
   * @param inArea 地区号码，例如深圳就是755
   */
  public void setArea(String inArea) {
    _Area = inArea;
  }
  /**
   * 获得已经设置的地区号码
   * @return 地区号码
   */
  public String getArea() {
    return _Area;
  }
  /**
   * 设置固定电话号码
   * @param inNumber 电话号码
   */
  public void setNumber(String inNumber) {
    _Number = inNumber;
  }
  /**
   * 获得固定电话号码
   * @return 电话号码
   */
  public String getNumber() {
    return _Number;
  }
  /**
   * 设置分机号码
   * @param inExtension 分机号码
   */
  public void setExtension(String inExtension) {
    _Extension= inExtension ;
  }
  /**
   * 获取分机号码
   * @return 分机号码
   */
  public String getExtension() {
    return _Extension;
  }

}
