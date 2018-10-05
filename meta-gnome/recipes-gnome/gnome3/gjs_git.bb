DESCRIPTION = "GNOME JavaScript engine"
LICENSE = "MIT|LGPLv2+"
DEPENDS = " \
            glib-2.0 \
            gsettings-desktop-schemas \
            mozjs \
            cairo \
          "

LIC_FILES_CHKSUM = "file://COPYING;md5=beb29cf17fabe736f0639b09ee6e76fa"

SRC_URI = "git://gitlab.gnome.org/GNOME/gjs.git;protocol=http;branch=master \
           file://0001-fix-override-allow.patch \
           "

# Last pre-mozjs60 merge commit. Once mozjs is upreved from 52->60,
# we can select a more sane version.
SRCREV="f2a8ca3dcfee06e03ae344932537951bc4d7739c"
S = "${WORKDIR}/git"

inherit autotools pkgconfig gobject-introspection
EXTRA_OECONF += " --without-dbus-tests "

FILES_${PN} += "${datadir}"

do_configure_prepend() {
	export GI_DATADIR="${RECIPE_SYSROOT_NATIVE}${datadir}/gobject-introspection-1.0"
	sed -i 's#mozjs-17#mozjs-52#g' ${S}/configure.ac
}

