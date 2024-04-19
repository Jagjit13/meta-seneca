SUMMARY = "Description of the input-app recipe"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=..."

SRC_URI = "file://${WORKDIR}/input_app.c"

S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} -o input_app input_app.c
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 input_app ${D}${bindir}
}

