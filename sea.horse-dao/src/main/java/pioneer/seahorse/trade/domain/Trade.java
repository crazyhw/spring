package pioneer.seahorse.trade.domain;

import pioneer.seahorse.base.domain.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Trade 类
 * @author 于靖鑫
 * @Date  2019/4/15 16:35
 */
@Entity
@Table(name = "SH_Trade")
public class Trade extends BaseEntity {

    @Column(name = "num")
    String num;
    @Column(name = "name")
    String name;
    @Column(name = "marks")
    String marks;

    public String getNum() { return num; }

    public void setNum(String num) { this.num = num; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getMarks() { return marks; }

    public void setMarks(String marks) { this.marks = marks; }

}
