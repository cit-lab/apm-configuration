package cn.edu.sjtu.cit.apm.configuration.collection;

import cn.edu.sjtu.cit.apm.configuration.entity.MachineConfigEntity;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;

/**
 * Created by Pillar on 2015/8/16.
 */
public class MachineConfigCollection extends BaseConfigCollection<MachineConfigEntity> {
    public MachineConfigCollection() throws ConfigurationException {
        super();
        read("etc/machines.xml", "machines.machine");
    }

    public MachineConfigEntity createConfig(HierarchicalConfiguration configuration) {
        return new MachineConfigEntity(configuration);
    }
}
