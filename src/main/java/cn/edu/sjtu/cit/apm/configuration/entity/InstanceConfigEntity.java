package cn.edu.sjtu.cit.apm.configuration.entity;

import lombok.Getter;
import org.apache.commons.configuration.HierarchicalConfiguration;

/**
 * Created by Pillar on 2015/8/16.
 */
public class InstanceConfigEntity extends BaseConfigEntity {
    @Getter
    protected String application;
    @Getter
    protected String machine;

    public InstanceConfigEntity(HierarchicalConfiguration configuration) {
        super(configuration);
    }

    @Override
    public void readConfig() {
        // TODO: it's better to put name in parent class
        this.name = configuration.getString("name");
        this.application = configuration.getString("[@application]");
        this.machine = configuration.getString("[@machine]");
    }

    @Override
    public String toString() {
        return super.toString() + ",application=" + getApplication() + ",machine=" + getMachine();
    }
}
