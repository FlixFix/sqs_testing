import os
import sys
sys.path.insert(0, os.path.abspath('../../'))

project = 'SQS Testing'
copyright = '2025, Felix Rampf'
author = 'Felix Rampf'

extensions = [
    'sphinx.ext.autodoc',
    'sphinx.ext.viewcode',
    'sphinx_copybutton',
]

templates_path = ['_templates']
exclude_patterns = []

source_suffix = {
    '.rst': 'restructuredtext',
    '.adoc': 'asciidoc',
}

root_doc = 'index'

html_theme = 'furo'
html_static_path = ['_static']
pygments_dark_style = 'nord'
