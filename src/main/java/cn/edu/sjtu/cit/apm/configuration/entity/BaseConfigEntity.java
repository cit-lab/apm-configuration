package cn.edu.sjtu.cit.apm.configuration.entity;

import cn.edu.sjtu.cit.apm.configuration.InvalidConfigException;
import org.apache.commons.configuration.HierarchicalConfiguration;

/**
 * Created by Pillar on 2015/8/16.
 */
public abstract class BaseConfigEntity {
    protected String name;
    protected HierarchicalConfiguration configuration;

    public BaseConfigEntity(HierarchicalConfiguration configuration) {
        this.configuration = configuration;
        readConfig();
    }

    public abstract void readConfig();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.toString() + " name=" + getName();
    }
}
