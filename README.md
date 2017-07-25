# baba-jclouds-examples
jClouds library examples to create resources on Alibaba Cloud


jClouds is powerful java library to integrate with various public & private clouds. It provides abstraction layer to access the APIs that provided by each different cloud providers

Find the introduction to jClouds from the link below
https://jclouds.apache.org/

See link below to find the providers
https://jclouds.apache.org/reference/providers/

Below is link to Aliyun provider for jClouds
https://github.com/aliyun-beta/aliyun-jclouds

To run this example

1. Create a gradle project from your Eclipse
2. Add following items to dependencies section in your gradle.build
3. Gradle refresh
4. Rename sample.clientprofile to .clientprofile and make some changes with valid info
5. Build the project
6. Run

    dependencies {
    
    ...
    
    // https://mvnrepository.com/artifact/org.apache.jclouds/jclouds-all
    
    compile group: 'org.apache.jclouds', name: 'jclouds-all', version: '2.0.2'  
    
    // https://mvnrepository.com/artifact/io.github.aliyun-beta/aliyun-jclouds
    
    compile group: 'io.github.aliyun-beta', name: 'aliyun-jclouds', version: '1.0.0'
    
    // https://mvnrepository.com/artifact/io.github.aliyun-beta/aliyun-oss
    
    compile group: 'io.github.aliyun-beta', name: 'aliyun-oss', version: '1.0.0'
    
    // https://mvnrepository.com/artifact/io.github.aliyun-beta/aliyun-ecs
    
    compile group: 'io.github.aliyun-beta', name: 'aliyun-ecs', version: '1.0.0'
    
    // https://mvnrepository.com/artifact/io.github.aliyun-beta/aliyun-slb
    
    compile group: 'io.github.aliyun-beta', name: 'aliyun-slb', version: '1.0.0'      
    
    }

Be noted that the latest version of jClouds doesn't work properly with guava settings of the latest version of Gradle. If you see any errors like below, just remark the line from gradle.build regarding guava 


    Exception in thread "main" java.util.ServiceConfigurationError: org.jclouds.providers.ProviderMetadata: Provider org.jclouds.aws.cloudwatch.AWSCloudWatchProviderMetadata could not be instantiated
    	at java.util.ServiceLoader.fail(ServiceLoader.java:232)
    	at java.util.ServiceLoader.access$100(ServiceLoader.java:185)
    	at java.util.ServiceLoader$LazyIterator.nextService(ServiceLoader.java:384)
    	at java.util.ServiceLoader$LazyIterator.next(ServiceLoader.java:404)
    	at java.util.ServiceLoader$1.next(ServiceLoader.java:480)
    	at com.google.common.collect.ImmutableCollection$Builder.addAll(ImmutableCollection.java:416)
    	at com.google.common.collect.ImmutableCollection$ArrayBasedBuilder.addAll(ImmutableCollection.java:500)
    	at com.google.common.collect.ImmutableSet$Builder.addAll(ImmutableSet.java:518)
    	at org.jclouds.providers.Providers.all(Providers.java:83)
    	at org.jclouds.providers.Providers.withId(Providers.java:99)
    	at org.jclouds.ContextBuilder.newBuilder(ContextBuilder.java:167)
    	at com.eg.baba.remote.jclouds.Main.perform(Main.java:42)
    	at com.eg.baba.remote.jclouds.Main.main(Main.java:29)
    Caused by: java.lang.NoClassDefFoundError: com/google/common/base/Objects$ToStringHelper
    	at java.lang.Class.getDeclaredMethods0(Native Method)
    	at java.lang.Class.privateGetDeclaredMethods(Class.java:2701)
    	at java.lang.Class.getDeclaredMethods(Class.java:1975)


jClouds ports of Aliyun components are still at beta. This is not for the serious purpose