SUMMARY = "Example of how to build an external Linux kernel module"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit module

SRC_URI = "git://github.com/Jagjit13/lab-8-source-code.git;protocol=https;branch=main \
           file://Makefile \
           file://pmu-mod.c \
           file://COPYING"

SRCREV = "f26b70b5c7e1583c04b8ab8c3d8e4daf59b76a85"

S = "${WORKDIR}"

RPROVIDES:${PN} += "kernel-module-pmu-mod"

MODULE_NAME = "pmu-mod"

do_compile() {
    oe_runmake -C ${STAGING_KERNEL_DIR} M=${S} modules
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/kernel/drivers/pmu
    install -m 0755 ${B}/pmu-mod.ko ${D}${nonarch_base_libdir}/kernel/drivers/pmu
}

FILES_${PN} += "${nonarch_base_libdir}/kernel/drivers/pmu/pmu-mod.ko"

# Adjust as necessary for target machine
COMPATIBLE_MACHINE = "(beagleplay)"

