plugins {
    `java-library`
}

version = "2.0.0"

tasks.compileJava {
    // Set module version as described at
    // https://docs.gradle.org/8.14/userguide/java_library_plugin.html#declaring_module_versions
    options.javaModuleVersion = provider {
        val ver = version as String
        if ( ver == Project.DEFAULT_VERSION ) null else ver
    }
    
    // Workaround for https://github.com/gradle/gradle/issues/34989
    // Module version is not set when module path is empty
    // When the fix makes it into a released version of Gradle, we
    // should test on project.gradle.gradleVersion to only apply
    // this workaround when necessary.
    options.compilerArgs.add("--module-path")
    options.compilerArgs.add(project.layout.projectDirectory.asFile.toString())
}
