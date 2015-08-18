package cn.edu.sjtu.cit.apm.configuration.entity;

import lombok.Getter;
import org.apache.commons.configuration.HierarchicalConfiguration;

/**
 * Created by Pillar on 2015/8/16.
 */
public class MachineConfigEntity extends BaseConfigEntity {
    @Getter
    protected String ip;

    public MachineConfigEntity(HierarchicalConfiguration configuration) {
        super(configuration);
    }

    @Override
    public void readConfig() {
        this.name = configuration.getString("name");
        this.ip = configuration.getString("ip");
    }

    @Override
    public String toString() {
        return super.toString() + ",ip=" + getIp();
    }
}
