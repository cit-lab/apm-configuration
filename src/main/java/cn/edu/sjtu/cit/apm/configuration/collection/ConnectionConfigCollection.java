package cn.edu.sjtu.cit.apm.configuration.collection;

import cn.edu.sjtu.cit.apm.configuration.entity.ConnectionConfigEntity;
import org.apache.commons.configuration.HierarchicalConfiguration;

import java.util.List;

/**
 * Created by Pillar on 2015/8/16.
 */
public class ConnectionConfigCollection extends BaseConfigCollection<ConnectionConfigEntity> {

    public ConnectionConfigCollection(List<HierarchicalConfiguration> configurations) {
        super();
        read(configurations);
    }

    @Override
    public ConnectionConfigEntity createConfig(HierarchicalConfiguration configuration) {
        return new ConnectionConfigEntity(configuration);
    }
}
