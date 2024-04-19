DESCRIPTION = "Google C++ Testing Framework"
HOMEPAGE = "https://github.com/google/googletest"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bcf85baa89bf6202856a7f7239f91861"

SRC_URI = "https://github.com/google/googletest/archive/release-1.10.0.zip"
SRC_URI[md5sum] = "82358affdd7ab94854c8ee73a180fc53"
SRC_URI[sha256sum] = "94c634d499558a76fa649edb13721dce6e98fb1e7018dfaeba3cd7a083945e91"


FILESEXTRAPATHS:prepend := "${THISDIR}/${BP}:"

PR = "r1"

do_install() {
    _incdir=${includedir}/gtest
    _srcdir=${prefix}/src/gtest

    install -d ${D}${_incdir}/internal ${D}${_srcdir}/src ${D}${_srcdir}/cmake

    install -v -m 0644 ${S}/include/gtest/*.h ${D}${_incdir}
    install -v -m 0644 ${S}/include/gtest/internal/*.h ${D}${_incdir}/internal
    install -v -m 0644 ${S}/fused-src/gtest/* ${D}${_srcdir}/src
    install -v -m 0644 ${S}/CMakeLists.txt ${D}${_srcdir}
    install -v -m 0644 ${S}/cmake/* ${D}${_srcdir}/cmake
}

sysroot_stage_all:append() {
    sysroot_stage_dir ${D}${prefix}/src ${SYSROOT_DESTDIR}${prefix}/src
}

FILES_${PN}-dev += "${prefix}/src"

