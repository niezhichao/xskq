package cloud.nzc.model.po;

import cloud.nzc.model.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="dutylist")
public class DutyList extends BaseEntity {

    @Id
    @Column(name = "id")
    private String iD;
    @Column(name="did")
    private  String dId;//考勤编号
    @Column(name="sid")
    private  String sId;//学号
    @Column(name="state")
    private  String state;//状态
}
