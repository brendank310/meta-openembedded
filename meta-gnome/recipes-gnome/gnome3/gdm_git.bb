DESCRIPTION = "GNOME Desktop Manager"
LICENSE = "GPLv2"
DEPENDS = " \
           libcanberra \
           glib-2.0 \
           gtk+3 \
           accountsservice \
           plymouth \
           gconf-native \
           dconf-native \
          "

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://gitlab.gnome.org/GNOME/gdm.git;protocol=http;branch=master;tag=3.30.1 \
           "

S = "${WORKDIR}/git"

inherit autotools pkgconfig distro_features_check gobject-introspection gettext

FILES_${PN} += "${systemd_system_unitdir}"
FILES_${PN} += "${libdir}"
FILES_${PN} += "${datadir}"

do_configure_prepend() {
	install -d ${S}/build-aux
	sed -i '/AC_CHECK_FILE/d' ${S}/configure.ac
}

do_install_append() {
	rm -rf ${D}/var/run
}
