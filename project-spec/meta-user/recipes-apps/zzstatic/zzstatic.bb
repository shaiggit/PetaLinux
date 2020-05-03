#
# This file is the zzstatic recipe.
#

SUMMARY = "Simple zzstatic application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://zzstatic \
	"

S = "${WORKDIR}"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

inherit update-rc.d
INITSCRIPT_NAME = "zzstatic"
INITSCRIPT_PARAMS = "start 999 5 ."
do_install() {
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${S}/zzstatic ${D}${sysconfdir}/init.d/zzstatic
        install -d ${D}${sysconfdir}/rc5.d
        install -m 0755 ${S}/zzstatic ${D}${sysconfdir}/rc5.d/zzstatic
}
FILES_${PN} += "${sysconfdir}/*"
