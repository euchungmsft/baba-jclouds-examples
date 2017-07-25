package com.eg.baba.remote.jclouds;

import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.jclouds.ContextBuilder;
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.compute.RunNodesException;
import org.jclouds.compute.domain.Hardware;
import org.jclouds.compute.domain.HardwareBuilder;
import org.jclouds.compute.domain.Image;
import org.jclouds.compute.domain.NodeMetadata;
import org.jclouds.compute.domain.Template;
import org.jclouds.compute.domain.internal.TemplateImpl;
import org.jclouds.compute.options.TemplateOptions;
import org.jclouds.domain.Location;
import org.jclouds.domain.LocationBuilder;
import org.jclouds.domain.LocationScope;

import com.eg.baba.remote.ClientProfile;
import com.google.common.collect.ImmutableSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Main().perform();

	}

	private void perform() {
		// TODO Auto-generated method stub

		String provider = "aliyun-ecs";
		String key = ClientProfile.getKeyId();
		String secret = ClientProfile.getKeySecret();

		BasicConfigurator.configure();
		
		ComputeServiceContext context = ContextBuilder.newBuilder(provider).credentials(key, secret)
				.buildView(ComputeServiceContext.class);
		ComputeService compute = context.getComputeService();

		// // list images
		//
		// Set<? extends Image> items = compute.listImages();
		// items.forEach(t -> System.out.println(((Image) t).getId()));

		// // list nodes
		//
		// Set<? extends ComputeMetadata> items1 = compute.listNodes();
		// items1.forEach(t -> System.out.println(((ComputeMetadata) t).getId()));
		// ClientProfile.printObject(items1);

		// create nodes

		String region = "ap-northeast-1";

		Image image = compute.getImage(region+":centos_7_03_64_40G_alibase_20170625.vhd");
		Hardware hardware = new HardwareBuilder().id("ecs.e4.large").build();
		Location location = new LocationBuilder().scope(LocationScope.ZONE).id(region).description(region).build();

		TemplateOptions options = new TemplateOptions();
		options.blockUntilRunning(false);
		options.blockOnComplete(false);
		
		Template template = new TemplateImpl(image, hardware, location, options);
		Set<? extends NodeMetadata> set = null;
		try {
			set = compute.createNodesInGroup(region, 1, template);
		} catch (RunNodesException e) {
			set = ImmutableSet.<NodeMetadata>builder().build();
		}

	}

}
