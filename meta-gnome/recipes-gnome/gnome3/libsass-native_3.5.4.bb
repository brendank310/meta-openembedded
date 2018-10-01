DESCRIPTION = "A C/C++ implementation of a Sass compiler"
LICENSE = "MIT"
DEPENDS = " atk glib-2.0 gettext-native "

LIC_FILES_CHKSUM = "file://LICENSE;md5=2f8a76980411a3f1f1480b141ce06744"

SRC_URI = "https://github.com/sass/${BPN}/archive/${PV}.tar.gz \
           "

SRC_URI[md5sum] = "4af3f4ffd3e8cac1cb1c90ebc2dd41b2"
SRC_URI[sha256sum] = "5f61cbcddaf8e6ef7a725fcfa5d05297becd7843960f245197ebb655ff868770"

S = "${WORKDIR}/${BPN}-${PV}"

inherit autotools pkgconfig native

