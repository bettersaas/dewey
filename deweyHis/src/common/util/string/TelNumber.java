package common.util.string;

/**
 * <p>����: �绰����</p>
 * <p>����: ��ŵ绰���룬����֣�<br>
 * ������,������,�������,�ֻ���<br></p>
 * <p>����: �¿Ƽ���</p>
 * @version 1.0
 */

public class TelNumber {
  /**
   *   ������
   */
  private String _Country = null;
  /**
   * ������
   */
  private String _Area = null;
  /**
   * �绰����
   */
  private String _Number = null;
  /**
   * �ֻ���
   */
  private String _Extension = null;

  public TelNumber() {
  }
  /**
   * ���ù�����
   * @param inCountry  �����룬�����й�����86
   */
  public void setCountry(String inCountry) {
    _Country= inCountry;
  }
  /**
   * ��ȡ���Һ���
   * @return ���Һ���
   */
  public String getCountry() {
    return _Country;
  }
  /**
   * ���õ�������
   * @param inArea �������룬�������ھ���755
   */
  public void setArea(String inArea) {
    _Area = inArea;
  }
  /**
   * ����Ѿ����õĵ�������
   * @return ��������
   */
  public String getArea() {
    return _Area;
  }
  /**
   * ���ù̶��绰����
   * @param inNumber �绰����
   */
  public void setNumber(String inNumber) {
    _Number = inNumber;
  }
  /**
   * ��ù̶��绰����
   * @return �绰����
   */
  public String getNumber() {
    return _Number;
  }
  /**
   * ���÷ֻ�����
   * @param inExtension �ֻ�����
   */
  public void setExtension(String inExtension) {
    _Extension= inExtension ;
  }
  /**
   * ��ȡ�ֻ�����
   * @return �ֻ�����
   */
  public String getExtension() {
    return _Extension;
  }

}
