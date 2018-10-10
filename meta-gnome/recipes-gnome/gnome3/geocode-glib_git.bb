DESCRIPTION = "Geocode Library for glib"
LICENSE = "GPLv2"
DEPENDS = " \
           glib-2.0 \
           json-glib \
           libsoup-2.4 \
          "

LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605"

SRC_URI = "git://gitlab.gnome.org/GNOME/geocode-glib.git;protocol=http;branch=master;tag=3.26.0 \
           "

EXTRA_OEMESON += " -Denable-installed-tests=false -Denable-gtk-doc=false "

FILES_${PN} += "${datadir}"

S = "${WORKDIR}/git"

inherit pkgconfig meson gobject-introspection

