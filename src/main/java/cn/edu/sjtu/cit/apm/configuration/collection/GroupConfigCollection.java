package cn.edu.sjtu.cit.apm.configuration.collection;

import cn.edu.sjtu.cit.apm.configuration.entity.GroupConfigEntity;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;

/**
 * Created by Pillar on 2015/8/16.
 */
public class GroupConfigCollection extends BaseConfigCollection<GroupConfigEntity> {
    public GroupConfigCollection() throws ConfigurationException {
        super();
        read("etc/groups.xml", "groups.group");
    }

    @Override
    public GroupConfigEntity createConfig(HierarchicalConfiguration configuration) {
        return new GroupConfigEntity(configuration);
    }
}
