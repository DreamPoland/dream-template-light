import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

repositories {
    maven("https://repo.codemc.io/repository/nms")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    // -- spigot api -- (base)
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")

    // -- dream-platform --
    implementation("cc.dreamcode.platform:core:1.12.8")
    implementation("cc.dreamcode.platform:bukkit:1.12.8")

    // -- dream-utilities --
    implementation("cc.dreamcode:utilities:1.4.5")
    implementation("cc.dreamcode:utilities-bukkit:1.4.5")

    // -- injector --
    implementation("eu.okaeri:okaeri-injector:2.1.0")

    // -- placeholders --
    implementation("eu.okaeri:okaeri-placeholders-core:5.0.1")
}

tasks.withType<ShadowJar> {

    archiveFileName.set("Dream-Template-${project.version}.jar")

    minimize()

    relocate("eu.okaeri", "cc.dreamcode.template.libs.eu.okaeri")

    relocate("cc.dreamcode.platform", "cc.dreamcode.template.libs.cc.dreamcode.platform")
    relocate("cc.dreamcode.utilities", "cc.dreamcode.template.libs.cc.dreamcode.utilities")
}