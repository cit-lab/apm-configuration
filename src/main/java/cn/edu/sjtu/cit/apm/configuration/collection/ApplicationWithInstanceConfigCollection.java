package cn.edu.sjtu.cit.apm.configuration.collection;

import cn.edu.sjtu.cit.apm.configuration.entity.ApplicationWithInstanceConfigEntity;
import org.apache.commons.configuration.HierarchicalConfiguration;

import java.util.List;

/**
 * Created by Pillar on 2015/8/16.
 */
public class ApplicationWithInstanceConfigCollection extends BaseConfigCollection<ApplicationWithInstanceConfigEntity> {
    public ApplicationWithInstanceConfigCollection(List<HierarchicalConfiguration> configurations){
        super();
        read(configurations);
    }

    @Override public ApplicationWithInstanceConfigEntity createConfig(HierarchicalConfiguration configuration){
        return new ApplicationWithInstanceConfigEntity(configuration);
    }
}
