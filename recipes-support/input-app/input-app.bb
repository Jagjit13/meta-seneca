
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "file://input_app.c"
S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} -o ${WORKDIR}/input_app ${WORKDIR}/input_app.c
}

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${WORKDIR}/input_app ${D}/${bindir}/
}

FILES_${PN} += "${bindir}/input_app"

