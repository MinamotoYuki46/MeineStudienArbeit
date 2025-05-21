import resolve from '@rollup/plugin-node-resolve';
import commonjs from '@rollup/plugin-commonjs';
import terser from '@rollup/plugin-terser';
import postcss from 'rollup-plugin-postcss';
import fs from 'fs';
import path from 'path';

// Create directories if they don't exist
const dirs = ['public/assets/js', 'public/assets/css'];
dirs.forEach(dir => {
  if (!fs.existsSync(dir)) {
    fs.mkdirSync(dir, { recursive: true });
  }
});

// Copy Material tokens CSS to assets directory
try {
  const mdTokensSource = './node_modules/@material/web/tokens/md-tokens.css';
  const mdTokensTarget = './public/assets/css/md-tokens.css';
  
  if (fs.existsSync(mdTokensSource)) {
    fs.copyFileSync(mdTokensSource, mdTokensTarget);
    console.log('Material 3 tokens CSS copied successfully.');
  } else {
    console.warn('Material 3 tokens CSS not found. Make sure you have installed @material/web.');
  }
} catch (error) {
  console.error('Error copying Material 3 tokens:', error);
}

// Determine if we're in production mode
const production = process.env.NODE_ENV === 'production';

export default {
  input: 'resources/js/main.js',
  output: {
    file: 'public/assets/js/bundle.js',
    format: 'iife',  // safe for browsers
    sourcemap: true,
  },
  plugins: [
    resolve({
      browser: true,
      dedupe: ['lit']  // Deduplicate lit dependencies
    }),
    commonjs(),  // Convert CommonJS modules to ES6
    postcss({
      extract: path.resolve('public/assets/css/styles.css'),
      minimize: production,
      sourceMap: !production
    }),
    production && terser()  // Minify in production
  ]
};