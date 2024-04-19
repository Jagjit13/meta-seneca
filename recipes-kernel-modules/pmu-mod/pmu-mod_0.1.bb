SUMMARY = "Example of how to build an external Linux kernel module"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit module

SRC_URI = "git://github.com/Jagjit13/lab-8-source-code.git;protocol=https \
           file://Makefile \
           file://pmu-mod.c \
           file://COPYING \
          "

S = "${WORKDIR}"

SRCREV = "main"

RPROVIDES:${PN} += "pmu-mod"

