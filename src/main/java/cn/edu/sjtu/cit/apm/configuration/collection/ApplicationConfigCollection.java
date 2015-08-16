package cn.edu.sjtu.cit.apm.configuration.collection;

import cn.edu.sjtu.cit.apm.configuration.entity.ApplicationConfigEntity;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;

import java.util.List;

/**
 * Created by Pillar on 2015/8/16.
 */
public class ApplicationConfigCollection extends BaseConfigCollection<ApplicationConfigEntity> {
    public ApplicationConfigCollection() throws ConfigurationException{
        super();
        read("etc/applications.xml","applications.application");
    }

    // For applications inside application groups
    public ApplicationConfigCollection(List<HierarchicalConfiguration> configurations){
        super();
        read(configurations);
    }

    @Override public ApplicationConfigEntity createConfig(HierarchicalConfiguration configuration){
        return new ApplicationConfigEntity(configuration);
    }
}
