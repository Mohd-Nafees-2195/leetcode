/**
 * @param {string} val
 * @return {Object}
 */
var expect = function (val) {
    return {
        toBe: (newVal) => (newVal === val) ? true : (() => { throw new Error("Not Equal") })(),
        notToBe: (newVal) => (newVal !== val) ? true : (() => { throw new Error("Equal") })()
        // toBe: (newVal) => {
        //     if (newVal === val)
        //         return true;
        //     else
        //         throw new Error("Not Equal")
        // },
        // notToBe: (newVal) => {
        //     if (newVal !== val)
        //         return true;
        //     else
        //         throw new Error("Equal")
        // }
    }
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */