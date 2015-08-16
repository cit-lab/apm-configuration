package cn.edu.sjtu.cit.apm.configuration;


import cn.edu.sjtu.cit.apm.configuration.collection.ApplicationConfigCollection;
import cn.edu.sjtu.cit.apm.configuration.collection.GroupConfigCollection;
import cn.edu.sjtu.cit.apm.configuration.collection.InstanceConfigCollection;
import cn.edu.sjtu.cit.apm.configuration.collection.MachineConfigCollection;

/**
 * Created by Pillar on 2015/8/16.
 */
public class Play {
    public static void main(String[] args) throws Exception{
        System.out.println("This configuration play!");
        ApplicationConfigCollection ac = new ApplicationConfigCollection();
        System.out.println(ac.getAll().size());
        System.out.println(ac.getAll().get(0));
        System.out.println(ac);

        // now handle machine config
        MachineConfigCollection mc = new MachineConfigCollection();
        System.out.println(mc.getAll().size());
        System.out.println(mc.getAll().get(0));

        // now instance config, it DOES NOT check if application and machine is configured!
        InstanceConfigCollection ic = new InstanceConfigCollection();
        System.out.println(ic.getAll().size());
        System.out.println(ic.getAll().get(0));

        // now we read groups
        GroupConfigCollection gc = new GroupConfigCollection();
        System.out.println(gc);
        gc.getAll().get(0).getApplications().getAll().get(0);
    }
}
