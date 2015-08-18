package cn.edu.sjtu.cit.apm.configuration.collection;

import cn.edu.sjtu.cit.apm.configuration.entity.InstanceConfigEntity;
import cn.edu.sjtu.cit.apm.configuration.entity.MachineConfigEntity;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;

import java.util.List;

/**
 * Created by Pillar on 2015/8/16.
 */
public class InstanceConfigCollection extends BaseConfigCollection<InstanceConfigEntity> {
    public InstanceConfigCollection() throws ConfigurationException {
        super();
        read("etc/instances.xml", "instances.instance");
    }

    // For instances inside applications ( and these applications are inside application group)
    public InstanceConfigCollection(List<HierarchicalConfiguration> configurations) {
        super();
        read(configurations);
    }

    @Override
    public InstanceConfigEntity createConfig(HierarchicalConfiguration configuration) {
        return new InstanceConfigEntity(configuration);
    }
}
