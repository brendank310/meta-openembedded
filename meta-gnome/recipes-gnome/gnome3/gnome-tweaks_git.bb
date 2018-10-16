DESCRIPTION = "GNOME Tweaks"
LICENSE = "GPLv2"
DEPENDS = " \
            gnome-shell \
          "

LIC_FILES_CHKSUM = "file://LICENSES/GPL-3.0;md5=9eef91148a9b14ec7f9df333daebc746"

SRC_URI = "git://gitlab.gnome.org/GNOME/gnome-tweaks.git;protocol=http;branch=master;tag=3.30.1 \
           "

S = "${WORKDIR}/git"

FILES_${PN} += "${libdir}"
FILES_${PN} += "${datadir}"

inherit pkgconfig meson gobject-introspection gettext


