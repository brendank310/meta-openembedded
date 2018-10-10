DESCRIPTION = "libwacom"
LICENSE = "MIT"
DEPENDS = " \
            glib-2.0 \
            libgudev \
            libxml2 \
          "

LIC_FILES_CHKSUM = "file://COPYING;md5=40a21fffb367c82f39fd91a3b137c36e"

SRC_URI = "git://github.com/linuxwacom/libwacom.git;protocol=http;branch=master;tag=libwacom-0.31 \
           "

S = "${WORKDIR}/git"

inherit autotools pkgconfig distro_features_check 

