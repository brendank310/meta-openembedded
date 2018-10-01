DESCRIPTION = "libsass command line driver."
LICENSE = "MIT"
DEPENDS = " libsass-native "

LIC_FILES_CHKSUM = "file://LICENSE;md5=2f8a76980411a3f1f1480b141ce06744"

SRC_URI = "https://github.com/sass/${BPN}/archive/${PV}.tar.gz \
           "
SRC_URI[md5sum] = "f5c6aeb4e98c96d093f20295fc490f2c"
SRC_URI[sha256sum] = "26f54e31924b83dd706bc77df5f8f5553a84d51365f0e3c566df8de027918042"

S = "${WORKDIR}/${BPN}-${PV}"

inherit autotools pkgconfig distro_features_check native

