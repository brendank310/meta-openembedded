DESCRIPTION = "GNOME Shell"
LICENSE = "GPLv2"
DEPENDS = " \
            glib-2.0 \
            gsettings-desktop-schemas \
            gjs \
            gdm \
            gnome-desktop3 \
            mutter \
            wayland \
            wayland-protocols \
            evolution-data-server \
            libcroco \
            polkit \
            gnome-bluetooth \
            gstreamer \
            keybinder \
            gnome-settings-daemon \
            ibus \
            librsvg \
            sassc-native \
          "

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://gitlab.gnome.org/GNOME/gnome-shell.git;protocol=http;branch=master;tag=3.30.1 \
           file://0001-dont-detect-python.patch \
           "

RDEPENDS_gnome-shell += " python3-core python3-pygobject gnome-settings-daemon gnome-bluetooth gdm "
S = "${WORKDIR}/git"

inherit pkgconfig meson gobject-introspection gettext

EXTRA_OEMESON += " -Dman=false -Dnetworkmanager=false "

FILES_${PN} += "${datadir}"
FILES_${PN} += "${libdir}"
FILES_${PN} += "${bindir}"

do_configure_prepend() {
	# Fixup the gsettings version
	sed -i 's^3.27.90^3.24.1^g' ${S}/meson.build
	sed -i "s^@PYTHON3_PATH@^${RECIPE_SYSROOT_NATIVE}/${bindir}/python3^g" ${S}/meson.build
}

