package cn.edu.sjtu.cit.apm.configuration.entity;

import cn.edu.sjtu.cit.apm.configuration.collection.InstanceConfigCollection;
import lombok.Getter;
import org.apache.commons.configuration.HierarchicalConfiguration;

/**
 * Created by Pillar on 2015/8/16.
 */
public class ApplicationWithInstanceConfigEntity extends ApplicationConfigEntity {
    @Getter
    protected InstanceConfigCollection instances;

    public ApplicationWithInstanceConfigEntity(HierarchicalConfiguration configuration) {
        super(configuration);
    }

    @Override
    public void readConfig() {
        super.readConfig();
        this.instances = new InstanceConfigCollection(configuration.configurationsAt("instances.instance"));
    }

    @Override
    public String toString() {
        return super.toString() + "\n instances are \n" + getInstances().toString();
    }
}
